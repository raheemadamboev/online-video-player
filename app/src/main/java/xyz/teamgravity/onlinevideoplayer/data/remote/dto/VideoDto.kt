package xyz.teamgravity.onlinevideoplayer.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoDto(
    @SerialName("id") val id: Int,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int,
    @SerialName("url") val url: String,
    @SerialName("image") val image: String,
    @SerialName("duration") val duration: Int,
    @SerialName("user") val user: UserDto,
    @SerialName("video_files") val videoFiles: List<VideoFileDto>,
    @SerialName("video_pictures") val videoPictures: List<VideoPictureDto>
)