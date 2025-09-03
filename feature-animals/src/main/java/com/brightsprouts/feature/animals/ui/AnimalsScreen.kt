package com.brightsprouts.feature.animals.ui

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
fun AnimalsScreen(
    onNavigateBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit
) {
    val lessons = listOf(
        AnimalLesson("Farm Animals", "🐄", "Meet farm animals", "animals_farm_1"),
        AnimalLesson("Wild Animals", "🦁", "Discover wild animals", "animals_wild_1"),
        AnimalLesson("Ocean Animals", "🐠", "Explore ocean life", "animals_ocean_1"),
        AnimalLesson("Bird Friends", "🐦", "Learn about birds", "animals_birds_1"),
        AnimalLesson("Pet Animals", "🐕", "Meet our pet friends", "animals_pets_1"),
        AnimalLesson("Animal Sounds", "🔊", "Listen to animal sounds", "animals_sounds_1"),
        AnimalLesson("Animal Homes", "🏠", "Where animals live", "animals_homes_1"),
        AnimalLesson("Animal Quiz", "❓", "Test your knowledge", "animals_quiz_1")
    )
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Animal Lessons") },
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
                AnimalLessonCard(
                    lesson = lesson,
                    onClick = { onNavigateToLesson(lesson.id) }
                )
            }
        }
    }
}

@Composable
private fun AnimalLessonCard(
    lesson: AnimalLesson,
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

private data class AnimalLesson(
    val title: String,
    val emoji: String,
    val description: String,
    val id: String
)
