package xyz.teamgravity.onlinevideoplayer.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoScreenViewModel @Inject constructor(
    handle: SavedStateHandle
) : ViewModel() {

    val url: String by mutableStateOf(handle.get<String>("url") ?: "")
}