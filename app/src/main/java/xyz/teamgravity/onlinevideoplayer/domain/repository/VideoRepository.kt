package xyz.teamgravity.onlinevideoplayer.domain.repository

import xyz.teamgravity.onlinevideoplayer.core.Resource
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel

interface VideoRepository {

    ///////////////////////////////////////////////////////////////////////////
    // Get
    ///////////////////////////////////////////////////////////////////////////

    suspend fun getPopularVideos(page: Int): Resource<List<VideoModel>>
}