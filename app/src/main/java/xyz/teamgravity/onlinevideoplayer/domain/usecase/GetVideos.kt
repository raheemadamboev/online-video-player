package xyz.teamgravity.onlinevideoplayer.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel
import xyz.teamgravity.onlinevideoplayer.domain.repository.VideoRepository

class GetVideos(
    private val repository: VideoRepository
) {

    operator fun invoke(): Flow<PagingData<VideoModel>> {
        return repository.getVideos()
    }
}