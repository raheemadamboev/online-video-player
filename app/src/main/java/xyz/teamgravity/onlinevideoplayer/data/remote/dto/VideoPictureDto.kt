package xyz.teamgravity.onlinevideoplayer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VideoPictureDto(
    @SerializedName("id") val id: Int,
    @SerializedName("picture") val picture: String,
    @SerializedName("nr") val nr: Int
)