package xyz.teamgravity.onlinevideoplayer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("id") val id: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("author") val author: String,
    @SerializedName("url") val url: String,
    @SerializedName("download_url") val downloadUrl: String
)