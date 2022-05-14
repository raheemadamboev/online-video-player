package xyz.teamgravity.onlinevideoplayer.data.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import xyz.teamgravity.onlinevideoplayer.data.remote.dto.VideoDto
import xyz.teamgravity.onlinevideoplayer.data.remote.mapper.toModel
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel
import xyz.teamgravity.onlinevideoplayer.domain.repository.VideoRepository

class VideRepositoryImp(
    private val pager: Pager<Int, VideoDto>
) : VideoRepository {

    ///////////////////////////////////////////////////////////////////////////
    // Get
    ///////////////////////////////////////////////////////////////////////////

    override fun getVideos(): Flow<PagingData<VideoModel>> {
        return pager.flow.map { data -> data.map { dto -> dto.toModel() } }
    }
}