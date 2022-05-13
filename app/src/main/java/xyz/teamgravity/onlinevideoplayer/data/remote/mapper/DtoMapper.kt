package xyz.teamgravity.onlinevideoplayer.data.remote.mapper

import xyz.teamgravity.onlinevideoplayer.data.remote.api.VideoApi
import xyz.teamgravity.onlinevideoplayer.data.remote.dto.VideoDto
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel

fun VideoDto.toModel(): VideoModel {
    return VideoModel(
        id = id,
        url = VideoApi.VIDEO_URL,
        image = downloadUrl,
        author = author
    )
}