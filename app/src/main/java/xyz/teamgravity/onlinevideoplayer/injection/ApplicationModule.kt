package xyz.teamgravity.onlinevideoplayer.injection

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import xyz.teamgravity.onlinevideoplayer.data.remote.api.PexelsApi
import xyz.teamgravity.onlinevideoplayer.data.remote.datasource.VideoPagingSource
import xyz.teamgravity.onlinevideoplayer.data.repository.VideRepositoryImp
import xyz.teamgravity.onlinevideoplayer.domain.repository.VideoRepository
import xyz.teamgravity.onlinevideoplayer.domain.usecase.GetPopularVideos
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun providePexelsApi(): PexelsApi = Retrofit.Builder()
        .baseUrl(PexelsApi.BASE_URL)
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .build()
        .create(PexelsApi::class.java)

    @Provides
    @Singleton
    fun provideVideoPagingSource(pixelsApi: PexelsApi): VideoPagingSource = VideoPagingSource(pixelsApi)

    @Provides
    @Singleton
    fun provideVideoRepository(pexelsApi: PexelsApi): VideoRepository = VideRepositoryImp(pexelsApi)

    @Provides
    @Singleton
    fun provideGetPopularVideos(videoRepository: VideoRepository): GetPopularVideos = GetPopularVideos(videoRepository)
}