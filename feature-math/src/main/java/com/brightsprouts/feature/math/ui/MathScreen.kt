package com.brightsprouts.feature.math.ui

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brightsprouts.design.dimensions.BrightSproutsDimensions
import com.brightsprouts.design.theme.BrightSproutsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MathScreen(
    onNavigateBack: () -> Unit,
    onNavigateToLesson: (String) -> Unit
) {
    val lessons = listOf(
        MathLesson("Count to 5", "🔢", "Learn to count from 1 to 5", "math_counting_1"),
        MathLesson("Count to 10", "🔢", "Learn to count from 1 to 10", "math_counting_2"),
        MathLesson("Shapes", "🔷", "Learn basic shapes", "math_shapes_1"),
        MathLesson("Compare Numbers", "⚖️", "Compare which is bigger", "math_compare_1"),
        MathLesson("Add Numbers", "➕", "Learn simple addition", "math_add_1"),
        MathLesson("Subtract Numbers", "➖", "Learn simple subtraction", "math_subtract_1")
    )
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Math Lessons") },
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
                MathLessonCard(
                    lesson = lesson,
                    onClick = { onNavigateToLesson(lesson.id) }
                )
            }
        }
    }
}

@Composable
private fun MathLessonCard(
    lesson: MathLesson,
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

private data class MathLesson(
    val title: String,
    val emoji: String,
    val description: String,
    val id: String
)
