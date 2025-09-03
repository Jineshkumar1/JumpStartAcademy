package com.brightsprouts.tv.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brightsprouts.tv.ui.screen.*

@Composable
fun TvNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            TvHomeScreen(
                onNavigateToMath = { navController.navigate("math") },
                onNavigateToEnglish = { navController.navigate("english") },
                onNavigateToAnimals = { navController.navigate("animals") },
                onNavigateToKg = { navController.navigate("kg") },
                onNavigateToSettings = { navController.navigate("settings") }
            )
        }
        
        composable("math") {
            TvMathScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToLesson = { lessonId ->
                    navController.navigate("lesson/$lessonId")
                }
            )
        }
        
        composable("english") {
            TvEnglishScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToLesson = { lessonId ->
                    navController.navigate("lesson/$lessonId")
                }
            )
        }
        
        composable("animals") {
            TvAnimalsScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToLesson = { lessonId ->
                    navController.navigate("lesson/$lessonId")
                }
            )
        }
        
        composable("kg") {
            TvKgScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToLesson = { lessonId ->
                    navController.navigate("lesson/$lessonId")
                }
            )
        }
        
        composable("settings") {
            TvSettingsScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable("lesson/{lessonId}") { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId") ?: ""
            TvLessonPlayerScreen(
                lessonId = lessonId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
