package com.brightsprouts.tv.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brightsprouts.design.dimensions.BrightSproutsDimensions
import com.brightsprouts.tv.ui.model.TvLessonItem

@Composable
fun TvKgScreen(
    onNavigateBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit
) {
    // KG lessons matching mobile app
    val kgLessons = listOf(
        TvLessonItem("Colors", "🌈", "Learn all the colors", "kg_colors_1"),
        TvLessonItem("Shapes", "🔷", "Discover different shapes", "kg_shapes_1"),
        TvLessonItem("Days of Week", "📅", "Learn the days", "kg_days_1"),
        TvLessonItem("Months", "🗓️", "Learn the months", "kg_months_1"),
        TvLessonItem("Weather", "☀️", "Learn about weather", "kg_weather_1"),
        TvLessonItem("Community Helpers", "👮", "Meet helpers in our community", "kg_helpers_1"),
        TvLessonItem("Safety Rules", "🛡️", "Learn to stay safe", "kg_safety_1"),
        TvLessonItem("Healthy Habits", "💪", "Learn healthy habits", "kg_health_1")
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(BrightSproutsDimensions.spacingXL)
    ) {
        // Header with back button
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Spacer(modifier = Modifier.width(BrightSproutsDimensions.spacingM))
            Text(
                text = "KG Topics",
                style = MaterialTheme.typography.displayMedium
            )
        }
        
        Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingL))
        
        Text(
            text = "Choose a topic to start learning!",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = BrightSproutsDimensions.spacingXL)
        )
        
        // Lessons column
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(BrightSproutsDimensions.spacingL)
        ) {
            items(kgLessons) { lesson ->
                TvLessonCard(
                    lesson = lesson,
                    onNavigateToLesson = onNavigateToLesson,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )
            }
        }
    }
}

@Composable
private fun TvLessonCard(
    lesson: TvLessonItem,
    onNavigateToLesson: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }
    
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    
    Card(
        modifier = modifier
            .focusRequester(focusRequester),
        onClick = { onNavigateToLesson(lesson.id) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(BrightSproutsDimensions.spacingL),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = lesson.emoji,
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingM))
            Text(
                text = lesson.title,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingS))
            Text(
                text = lesson.description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


