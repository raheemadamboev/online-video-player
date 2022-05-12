package xyz.teamgravity.onlinevideoplayer.presentation.navigation

sealed class Screen(val route: String) {
    object VideoList : Screen("video_list")
    object Video : Screen("video")
}
