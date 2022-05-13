package xyz.teamgravity.onlinevideoplayer.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import xyz.teamgravity.onlinevideoplayer.R
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel

@Composable
fun VideoCard(
    video: VideoModel,
    onClick: (id: Int) -> Unit,
) {
    Card(
        onClick = { onClick(video.id) },
        modifier = Modifier.padding(10.dp)
    ) {
        Column(Modifier.fillMaxWidth()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(video.image)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.video_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(id = R.string.video_name))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = video.username)
        }
    }
}