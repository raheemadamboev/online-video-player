package xyz.teamgravity.onlinevideoplayer.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PopularVideosResponseDto(
    @SerializedName("videos") val videos: List<VideoDto>,
    @SerializedName("url") val url: String,
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("prev_page") val prevPage: String?,
    @SerializedName("next_page") val nextPage: String?
)
