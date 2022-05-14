package xyz.teamgravity.onlinevideoplayer.injection

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import retrofit2.Retrofit
import xyz.teamgravity.onlinevideoplayer.data.remote.api.VideoApi
import xyz.teamgravity.onlinevideoplayer.data.remote.datasource.VideoPagingSource
import xyz.teamgravity.onlinevideoplayer.data.remote.dto.VideoDto
import xyz.teamgravity.onlinevideoplayer.data.repository.VideRepositoryImp
import xyz.teamgravity.onlinevideoplayer.domain.repository.VideoRepository
import xyz.teamgravity.onlinevideoplayer.domain.usecase.GetVideos
import javax.inject.Singleton

@Suppress("JSON_FORMAT_REDUNDANT")
@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory = Json {
        ignoreUnknownKeys = true
    }.asConverterFactory("application/json".toMediaType())

    @Provides
    @Singleton
    fun provideVideoApi(factory: Converter.Factory): VideoApi = Retrofit.Builder()
        .baseUrl(VideoApi.BASE_URL)
        .addConverterFactory(factory)
        .build()
        .create(VideoApi::class.java)

    @Provides
    @Singleton
    fun provideVideoPagingSource(videoApi: VideoApi): VideoPagingSource = VideoPagingSource(videoApi)

    @Provides
    @Singleton
    fun providePagingConfig(): PagingConfig = PagingConfig(
        pageSize = VideoApi.PER_PAGE,
        maxSize = VideoApi.MAX_SIZE,
        enablePlaceholders = false
    )

    @Provides
    @Singleton
    fun providePager(pagingConfig: PagingConfig, videoPagingSource: VideoPagingSource): Pager<Int, VideoDto> = Pager(
        config = pagingConfig,
        pagingSourceFactory = { videoPagingSource }
    )

    @Provides
    @Singleton
    fun provideVideoRepository(pager: Pager<Int, VideoDto>): VideoRepository = VideRepositoryImp(pager)

    @Provides
    @Singleton
    fun provideGetVideos(videoRepository: VideoRepository): GetVideos = GetVideos(videoRepository)
}