package xyz.teamgravity.onlinevideoplayer.domain.repository

import xyz.teamgravity.onlinevideoplayer.core.util.Resource
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel

interface VideoRepository {

    ///////////////////////////////////////////////////////////////////////////
    // Get
    ///////////////////////////////////////////////////////////////////////////

    suspend fun getPopularVideos(page: Int): List<VideoModel>
}