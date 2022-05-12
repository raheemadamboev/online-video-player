package xyz.teamgravity.onlinevideoplayer.data.remote.mapper

import xyz.teamgravity.onlinevideoplayer.data.remote.dto.VideoDto
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel

fun VideoDto.toModel(): VideoModel {
    return VideoModel(
        id = id,
        url = videoFiles.firstOrNull()?.link ?: "",
        image = image,
        duration = duration,
        username = user.name
    )
}