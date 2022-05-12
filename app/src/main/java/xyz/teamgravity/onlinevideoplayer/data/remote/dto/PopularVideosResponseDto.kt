package xyz.teamgravity.onlinevideoplayer.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularVideosResponseDto(
    @SerialName("videos") val videos: List<VideoDto>,
    @SerialName("url") val url: String,
    @SerialName("page") val page: Int,
    @SerialName("per_page") val perPage: Int,
    @SerialName("total_results") val totalResults: Int,
    @SerialName("prev_page") val prevPage: String?,
    @SerialName("next_page") val nextPage: String?
)
