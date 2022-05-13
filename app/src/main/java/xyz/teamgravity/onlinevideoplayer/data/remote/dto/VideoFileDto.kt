package xyz.teamgravity.onlinevideoplayer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VideoFileDto(
    @SerializedName("id") val id: Int,
    @SerializedName("quality") val quality: String,
    @SerializedName("file_type") val fileType: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("link") val link: String
)