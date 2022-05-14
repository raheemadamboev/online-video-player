package xyz.teamgravity.onlinevideoplayer.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView
import timber.log.Timber

@Composable
fun VideoPlayer(
    url: String,
) {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    var play by rememberSaveable { mutableStateOf(true) }
    Timber.d("play: $play")
    var mediaIndex by rememberSaveable { mutableStateOf(0) }
    Timber.d("mediaIndex: $mediaIndex")
    var position by rememberSaveable { mutableStateOf(0L) }
    Timber.d("position: $position")

    val player = remember { StyledPlayerView(context) }
    val exoplayer = remember {
        ExoPlayer.Builder(context).build().apply {
            addMediaItem(MediaItem.fromUri(url))
            prepare()
            playWhenReady = play
            seekTo(mediaIndex, position)
            Timber.d("exoplayer created again")
        }
    }

    fun updateState() {
        play = exoplayer.playWhenReady
        Timber.d("updateState: play: $play")
        mediaIndex = exoplayer.currentMediaItemIndex
        Timber.d("updateState: mediaIndex: $mediaIndex")
        position = exoplayer.contentPosition
        Timber.d("updateState: position: $position")
    }

    DisposableEffect(key1 = true) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    Timber.d("onStart")
                    player.onResume()
                    exoplayer.playWhenReady = play
                }
                Lifecycle.Event.ON_STOP -> {
                    Timber.d("onStop")
                    updateState()
                    player.onPause()
                    exoplayer.playWhenReady = false
                }
                else -> Unit
            }
        }
        lifecycle.addObserver(observer)

        onDispose {
            Timber.d("onDispose")
            lifecycle.removeObserver(observer)
            updateState()
            exoplayer.release()
            Timber.d("exoplayer released")
        }
    }

    AndroidView(
        factory = { player },
        modifier = Modifier.fillMaxWidth()
    ) {
        player.player = exoplayer
    }
}