package com.brightsprouts.feature.english.ui

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
fun EnglishScreen(
    onNavigateBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit
) {
    val lessons = listOf(
        EnglishLesson("Letters A-E", "🔤", "Learn letters A through E", "english_letters_1"),
        EnglishLesson("Letters F-J", "🔤", "Learn letters F through J", "english_letters_2"),
        EnglishLesson("Letters K-O", "🔤", "Learn letters K through O", "english_letters_3"),
        EnglishLesson("Letters P-T", "🔤", "Learn letters P through T", "english_letters_4"),
        EnglishLesson("Letters U-Z", "🔤", "Learn letters U through Z", "english_letters_5"),
        EnglishLesson("Phonics", "🔊", "Learn letter sounds", "english_phonics_1"),
        EnglishLesson("Sight Words", "👁️", "Learn common words", "english_sight_1"),
        EnglishLesson("Trace Letters", "✏️", "Practice writing letters", "english_trace_1")
    )
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("English Lessons") },
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
                EnglishLessonCard(
                    lesson = lesson,
                    onClick = { onNavigateToLesson(lesson.id) }
                )
            }
        }
    }
}

@Composable
private fun EnglishLessonCard(
    lesson: EnglishLesson,
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

private data class EnglishLesson(
    val title: String,
    val emoji: String,
    val description: String,
    val id: String
)
