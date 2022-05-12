package xyz.teamgravity.onlinevideoplayer.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import xyz.teamgravity.onlinevideoplayer.R
import xyz.teamgravity.onlinevideoplayer.core.util.Resource
import xyz.teamgravity.onlinevideoplayer.core.util.UniversalText
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel
import xyz.teamgravity.onlinevideoplayer.domain.repository.VideoRepository

class GetPopularVideos(
    private val repository: VideoRepository
) {

    operator fun invoke(): Flow<PagingData<VideoModel>> {
        return repository.getPopularVideos()
    }
}