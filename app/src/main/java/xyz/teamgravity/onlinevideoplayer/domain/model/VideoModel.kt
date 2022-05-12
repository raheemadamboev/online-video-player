package xyz.teamgravity.onlinevideoplayer.domain.model

data class VideoModel(
    val id: Int,
    val url: String,
    val image: String,
    val duration: Int, // seconds
    val username: String
)
