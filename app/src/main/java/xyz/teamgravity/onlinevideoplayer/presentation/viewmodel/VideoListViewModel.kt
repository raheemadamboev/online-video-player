package xyz.teamgravity.onlinevideoplayer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel
import xyz.teamgravity.onlinevideoplayer.domain.usecase.GetPopularVideos
import javax.inject.Inject

@HiltViewModel
class VideoListViewModel @Inject constructor(
    getPopularVideos: GetPopularVideos
) : ViewModel() {

    val videos: Flow<PagingData<VideoModel>> = getPopularVideos().cachedIn(viewModelScope)
}