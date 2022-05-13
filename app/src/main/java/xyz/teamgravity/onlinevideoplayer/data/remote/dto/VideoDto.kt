package xyz.teamgravity.onlinevideoplayer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("id") val id: Int,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("url") val url: String,
    @SerializedName("image") val image: String,
    @SerializedName("duration") val duration: Int,
    @SerializedName("user") val user: UserDto,
    @SerializedName("video_files") val videoFiles: List<VideoFileDto>,
    @SerializedName("video_pictures") val videoPictures: List<VideoPictureDto>
)