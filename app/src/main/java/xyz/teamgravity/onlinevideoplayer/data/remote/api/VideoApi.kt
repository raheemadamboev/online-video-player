package xyz.teamgravity.onlinevideoplayer.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query
import xyz.teamgravity.onlinevideoplayer.data.remote.dto.VideoDto

interface VideoApi {

    companion object {
        const val BASE_URL = "https://picsum.photos"
        const val PAGE = 1
        const val PER_PAGE = 10
        const val MAX_SIZE = 60
        const val VIDEO_URL =
            "https://firebasestorage.googleapis.com/v0/b/spotify-clone-702f3.appspot.com/o/video%2Falone.mp4?alt=media&token=73be6ebd-3f5f-4d2b-a3e5-1c9458e4734f"
    }

    ///////////////////////////////////////////////////////////////////////////
    // Get
    ///////////////////////////////////////////////////////////////////////////

    @GET("/v2/list")
    suspend fun getPopularVideos(
        @Query("page") page: Int,
        @Query("limit") perPage: Int,
    ): List<VideoDto>
}