package xyz.teamgravity.onlinevideoplayer.injection

import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.teamgravity.onlinevideoplayer.data.remote.api.PexelsApi
import xyz.teamgravity.onlinevideoplayer.data.remote.datasource.VideoPagingSource
import xyz.teamgravity.onlinevideoplayer.data.remote.dto.VideoDto
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
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PexelsApi::class.java)

    @Provides
    @Singleton
    fun provideVideoPagingSource(pexelsApi: PexelsApi): VideoPagingSource = VideoPagingSource(pexelsApi)

    @Provides
    @Singleton
    fun providePager(videoPagingSource: VideoPagingSource): Pager<Int, VideoDto> = Pager(
        config = PagingConfig(
            pageSize = PexelsApi.PER_PAGE,
            maxSize = PexelsApi.MAX_SIZE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { videoPagingSource }
    )

    @Provides
    @Singleton
    fun provideVideoRepository(pager: Pager<Int, VideoDto>): VideoRepository = VideRepositoryImp(pager)

    @Provides
    @Singleton
    fun provideGetPopularVideos(videoRepository: VideoRepository): GetPopularVideos = GetPopularVideos(videoRepository)
}