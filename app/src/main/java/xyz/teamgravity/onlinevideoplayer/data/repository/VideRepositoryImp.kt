package xyz.teamgravity.onlinevideoplayer.data.repository

import xyz.teamgravity.onlinevideoplayer.data.remote.api.PexelsApi
import xyz.teamgravity.onlinevideoplayer.data.remote.mapper.toModel
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel
import xyz.teamgravity.onlinevideoplayer.domain.repository.VideoRepository

class VideRepositoryImp(
    private val api: PexelsApi
) : VideoRepository {

    ///////////////////////////////////////////////////////////////////////////
    // Get
    ///////////////////////////////////////////////////////////////////////////

    override suspend fun getPopularVideos(page: Int): List<VideoModel> {
        return api.getPopularVideos(page = page).videos.map { it.toModel() }
    }
}