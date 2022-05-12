package xyz.teamgravity.onlinevideoplayer.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import xyz.teamgravity.onlinevideoplayer.data.remote.dto.PopularVideosResponseDto

interface PexelsApi {

    companion object {
        const val BASE_URL = "https://api.pexels.com"
        private const val TOKEN = "563492ad6f917000010000013fa6fe0ca1ef40ff9c8a88d79e6818fc"
        const val PAGE = 1
        const val PER_PAGE = 10
        const val MAX_SIZE = 60
        private const val MAX_DURATION = 60
    }

    ///////////////////////////////////////////////////////////////////////////
    // Get
    ///////////////////////////////////////////////////////////////////////////

    @GET("/videos/popular")
    suspend fun getPopularVideos(
        @Header("Authorization") token: String = TOKEN,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("max_duration") maxDuration: Int = MAX_DURATION
    ): PopularVideosResponseDto
}