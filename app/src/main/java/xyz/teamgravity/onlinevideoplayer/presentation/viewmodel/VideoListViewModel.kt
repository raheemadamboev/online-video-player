package xyz.teamgravity.onlinevideoplayer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.onlinevideoplayer.domain.model.VideoModel
import xyz.teamgravity.onlinevideoplayer.domain.usecase.GetPopularVideos
import javax.inject.Inject

@HiltViewModel
class VideoListViewModel @Inject constructor(
    getPopularVideos: GetPopularVideos
) : ViewModel() {

    val videos: Flow<PagingData<VideoModel>> = getPopularVideos()
}