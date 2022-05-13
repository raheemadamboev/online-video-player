package xyz.teamgravity.onlinevideoplayer.data.remote.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import timber.log.Timber
import xyz.teamgravity.onlinevideoplayer.data.remote.api.VideoApi
import xyz.teamgravity.onlinevideoplayer.data.remote.dto.VideoDto

class VideoPagingSource(
    private val api: VideoApi
) : PagingSource<Int, VideoDto>() {

    override fun getRefreshKey(state: PagingState<Int, VideoDto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VideoDto> {
        val page = params.key ?: VideoApi.PAGE

        return try {
            val videos = api.getPopularVideos(
                page = page,
                perPage = params.loadSize
            )

            Timber.d("Just api request")

            LoadResult.Page(
                data = videos,
                prevKey = if (page == VideoApi.PAGE) null else page - 1,
                nextKey = if (videos.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}