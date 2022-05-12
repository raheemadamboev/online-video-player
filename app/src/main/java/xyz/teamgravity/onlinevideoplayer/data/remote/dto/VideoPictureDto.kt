package xyz.teamgravity.onlinevideoplayer.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoPictureDto(
    @SerialName("id") val id: Int,
    @SerialName("picture") val picture: String,
    @SerialName("nr") val nr: Int
)