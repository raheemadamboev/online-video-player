package xyz.teamgravity.onlinevideoplayer.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import xyz.teamgravity.onlinevideoplayer.R
import xyz.teamgravity.onlinevideoplayer.core.util.Resource
import xyz.teamgravity.onlinevideoplayer.core.util.UniversalText
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel
import xyz.teamgravity.onlinevideoplayer.domain.repository.VideoRepository

class GetPopularVideos(
    private val repository: VideoRepository
) {

    operator fun invoke(page: Int): Flow<Resource<List<VideoModel>>> {
        return flow {
            emit(Resource.Loading())
            try {
                emit(Resource.Success(repository.getPopularVideos(page)))
            } catch (e: Exception) {
                emit(Resource.Error(message = UniversalText.Resource(id = R.string.error_getting_videos)))
            }
        }
    }
}