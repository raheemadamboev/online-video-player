package xyz.teamgravity.onlinevideoplayer.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.onlinevideoplayer.core.util.Resource
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel

interface VideoRepository {

    ///////////////////////////////////////////////////////////////////////////
    // Get
    ///////////////////////////////////////////////////////////////////////////

    suspend fun getPopularVideos(page: Int): Flow<PagingData<VideoModel>>
}