package xyz.teamgravity.onlinevideoplayer.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import xyz.teamgravity.onlinevideoplayer.R
import xyz.teamgravity.onlinevideoplayer.presentation.component.VideoPlayer
import xyz.teamgravity.onlinevideoplayer.presentation.viewmodel.VideoScreenViewModel

@Composable
fun VideoScreen(
    viewmodel: VideoScreenViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = stringResource(id = R.string.watch_video)) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(id = R.string.cd_back_button)
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            VideoPlayer(
                url = viewmodel.url
            )
        }
    }
}