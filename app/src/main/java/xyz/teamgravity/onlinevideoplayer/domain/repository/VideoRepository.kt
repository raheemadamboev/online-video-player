package xyz.teamgravity.onlinevideoplayer.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel

interface VideoRepository {

    ///////////////////////////////////////////////////////////////////////////
    // Get
    ///////////////////////////////////////////////////////////////////////////

    fun getVideos(): Flow<PagingData<VideoModel>>
}