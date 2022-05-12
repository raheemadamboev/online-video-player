package xyz.teamgravity.onlinevideoplayer.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoFileDto(
    @SerialName("id") val id: Int,
    @SerialName("quality") val quality: String,
    @SerialName("file_type") val fileType: String,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int,
    @SerialName("link") val link: String
)