package xyz.teamgravity.onlinevideoplayer.presentation.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import xyz.teamgravity.onlinevideoplayer.R
import xyz.teamgravity.onlinevideoplayer.presentation.component.CenteredProgressBar
import xyz.teamgravity.onlinevideoplayer.presentation.component.VideoCard
import xyz.teamgravity.onlinevideoplayer.presentation.viewmodel.VideoListViewModel

@Composable
fun VideoListScreen(
    viewmodel: VideoListViewModel = hiltViewModel(),
    onNavigateVideo: (url: String) -> Unit,
) {
    val snackbar = remember { SnackbarHostState() }
    val scroll = remember { TopAppBarDefaults.enterAlwaysScrollBehavior() }
    val videos = viewmodel.videos.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = stringResource(id = R.string.videos)) },
                actions = {
                    IconButton(onClick = viewmodel::onHeartCheckedChange) {
                        Icon(
                            imageVector = if (viewmodel.heartChecked) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = stringResource(id = R.string.cd_favourite_button)
                        )
                    }
                },
                scrollBehavior = scroll
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbar) { data ->
                Snackbar(snackbarData = data)
            }
        },
        modifier = Modifier.nestedScroll(scroll.nestedScrollConnection)
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            if (videos.loadState.prepend == LoadState.Loading) item { CenteredProgressBar() }

            items(
                items = videos,
                key = { video -> video.id }
            ) { video ->
                video?.let {
                    VideoCard(
                        video = it,
                        onClick = onNavigateVideo
                    )
                }
            }

            when (val append = videos.loadState.append) {
                LoadState.Loading -> item { CenteredProgressBar() }
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