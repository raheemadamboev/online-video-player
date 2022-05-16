package xyz.teamgravity.onlinevideoplayer.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel
import xyz.teamgravity.onlinevideoplayer.domain.usecase.GetVideos
import javax.inject.Inject

@HiltViewModel
class VideoListViewModel @Inject constructor(
    getVideos: GetVideos,
    private val handle: SavedStateHandle,
) : ViewModel() {

    companion object {
        private const val HEART_CHECKED = "heartChecked"
        private const val HEART_CHECKED_DEFAULT = false
    }

    val videos: Flow<PagingData<VideoModel>> = getVideos().cachedIn(viewModelScope)

    var heartChecked: Boolean by mutableStateOf(handle.get<Boolean>(HEART_CHECKED) ?: HEART_CHECKED_DEFAULT)
        private set

    fun onHeartCheckedChange() {
        handle[HEART_CHECKED] = !heartChecked
        heartChecked = !heartChecked
    }
}