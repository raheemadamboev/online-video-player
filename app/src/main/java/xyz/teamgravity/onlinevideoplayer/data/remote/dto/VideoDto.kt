package xyz.teamgravity.onlinevideoplayer.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoDto(
    @SerialName("id") val id: String,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int,
    @SerialName("author") val author: String,
    @SerialName("url") val url: String,
    @SerialName("download_url") val downloadUrl: String
)