package xyz.teamgravity.onlinevideoplayer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import xyz.teamgravity.onlinevideoplayer.presentation.screen.VideoListScreen
import xyz.teamgravity.onlinevideoplayer.presentation.screen.VideoScreen

@Composable
fun Navigation(
    controller: NavHostController = rememberNavController()
) {
    NavHost(navController = controller, startDestination = Screen.VideoList.route) {
        composable(route = Screen.VideoList.route) {
            VideoListScreen(
                onNavigateVideo = { id ->
                    controller.navigate("${Screen.Video.route}?id=$id")
                }
            )
        }
        composable(
            route = "${Screen.Video.route}?id={id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            VideoScreen { controller.popBackStack() }
        }
    }
}