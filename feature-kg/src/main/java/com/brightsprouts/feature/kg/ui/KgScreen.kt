package com.brightsprouts.feature.kg.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brightsprouts.design.dimensions.BrightSproutsDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KgScreen(
    onNavigateBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit
) {
    val lessons = listOf(
        KgLesson("Colors", "🌈", "Learn all the colors", "kg_colors_1"),
        KgLesson("Shapes", "🔷", "Discover different shapes", "kg_shapes_1"),
        KgLesson("Days of Week", "📅", "Learn the days", "kg_days_1"),
        KgLesson("Months", "🗓️", "Learn the months", "kg_months_1"),
        KgLesson("Weather", "☀️", "Learn about weather", "kg_weather_1"),
        KgLesson("Community Helpers", "👮", "Meet helpers in our community", "kg_helpers_1"),
        KgLesson("Safety Rules", "🛡️", "Learn to stay safe", "kg_safety_1"),
        KgLesson("Healthy Habits", "💪", "Learn healthy habits", "kg_health_1")
    )
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("KG Topics") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(BrightSproutsDimensions.spacingM),
            verticalArrangement = Arrangement.spacedBy(BrightSproutsDimensions.spacingM)
        ) {
            items(lessons) { lesson ->
                KgLessonCard(
                    lesson = lesson,
                    onClick = { onNavigateToLesson(lesson.id) }
                )
            }
        }
    }
}

@Composable
private fun KgLessonCard(
    lesson: KgLesson,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = BrightSproutsDimensions.elevationM)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(BrightSproutsDimensions.spacingL),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = lesson.emoji,
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.width(BrightSproutsDimensions.spacingM))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = lesson.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingXS))
                Text(
                    text = lesson.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Icon(
                imageVector = androidx.compose.material.icons.Icons.Default.PlayArrow,
                contentDescription = "Start lesson",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

private data class KgLesson(
    val title: String,
    val emoji: String,
    val description: String,
    val id: String
)
