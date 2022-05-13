package xyz.teamgravity.onlinevideoplayer.presentation.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import xyz.teamgravity.onlinevideoplayer.presentation.component.VideoCard
import xyz.teamgravity.onlinevideoplayer.presentation.viewmodel.VideoListViewModel

@Composable
fun VideoListScreen(
    viewmodel: VideoListViewModel = hiltViewModel(),
    onNavigateVideo: (id: Int) -> Unit
) {
    val videos = viewmodel.videos.collectAsLazyPagingItems()

    LazyColumn {
        if (videos.loadState.refresh == LoadState.Loading) {
            item {
                CircularProgressIndicator()
            }
        }
        items(videos) { video ->
            video?.let {
                VideoCard(
                    video = it,
                    onClick = onNavigateVideo
                )
            }
        }
        if (videos.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator()
            }
        }
    }
}