package com.brightsprouts.mobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brightsprouts.feature.animals.ui.AnimalsScreen
import com.brightsprouts.feature.english.ui.EnglishScreen
import com.brightsprouts.feature.kg.ui.KgScreen
import com.brightsprouts.feature.math.ui.MathScreen
import com.brightsprouts.mobile.ui.screen.home.HomeScreen
import com.brightsprouts.mobile.ui.screen.lesson.LessonPlaceholderScreen
import com.brightsprouts.mobile.ui.screen.settings.SettingsScreen

@Composable
fun JumpStartAcademyNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onNavigateToMath = { navController.navigate("math") },
                onNavigateToEnglish = { navController.navigate("english") },
                onNavigateToAnimals = { navController.navigate("animals") },
                onNavigateToKg = { navController.navigate("kg") },
                onNavigateToSettings = { navController.navigate("settings") }
            )
        }
        
        composable("math") {
            MathScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToLesson = { lessonId ->
                    navController.navigate("lesson/$lessonId")
                }
            )
        }
        
        composable("english") {
            EnglishScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToLesson = { lessonId ->
                    navController.navigate("lesson/$lessonId")
                }
            )
        }
        
        composable("animals") {
            AnimalsScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToLesson = { lessonId ->
                    navController.navigate("lesson/$lessonId")
                }
            )
        }
        
        composable("kg") {
            KgScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToLesson = { lessonId ->
                    navController.navigate("lesson/$lessonId")
                }
            )
        }
        
        composable("settings") {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable("lesson/{lessonId}") { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId") ?: ""
            // TODO: Load lesson by ID and pass to LessonPlayerScreen
            // For now, show a placeholder
            LessonPlaceholderScreen(
                lessonId = lessonId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
