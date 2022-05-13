package xyz.teamgravity.onlinevideoplayer.presentation.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import xyz.teamgravity.onlinevideoplayer.presentation.component.VideoCard
import xyz.teamgravity.onlinevideoplayer.presentation.viewmodel.VideoListViewModel

@Composable
fun VideoListScreen(
    viewmodel: VideoListViewModel = hiltViewModel(),
    onNavigateVideo: (url: String) -> Unit
) {
    val snackbar = remember { SnackbarHostState() }
    val videos = viewmodel.videos.collectAsLazyPagingItems()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbar) { data ->
                Snackbar(
                    snackbarData = data,
                    modifier = Modifier.border(2.dp, MaterialTheme.colorScheme.secondary)
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
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

            when (val append = videos.loadState.append) {
                LoadState.Loading -> item {
                    CircularProgressIndicator()
                }
                is LoadState.Error -> item {
                    LaunchedEffect(key1 = append) {
                        snackbar.showSnackbar(append.error.message ?: "")
                    }

                }
                else -> Unit
            }
        }
    }
}