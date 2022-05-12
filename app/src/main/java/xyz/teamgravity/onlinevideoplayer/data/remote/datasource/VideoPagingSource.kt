package xyz.teamgravity.onlinevideoplayer.data.remote.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import xyz.teamgravity.onlinevideoplayer.data.remote.api.PexelsApi
import xyz.teamgravity.onlinevideoplayer.data.remote.dto.VideoDto

class VideoPagingSource(
    private val api: PexelsApi
) : PagingSource<Int, VideoDto>() {

    companion object {
        private const val INDEX_START_PAGE = 1
    }

    override fun getRefreshKey(state: PagingState<Int, VideoDto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VideoDto> {
        val page = params.key ?: INDEX_START_PAGE

        return try {
            val response = api.getPopularVideos(
                page = page,
                perPage = params.loadSize
            )

            LoadResult.Page(
                data = response.videos,
                prevKey = if (page == INDEX_START_PAGE) null else page - 1,
                nextKey = if (response.videos.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}