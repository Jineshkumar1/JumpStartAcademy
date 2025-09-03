package com.brightsprouts.design.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brightsprouts.core.domain.model.Lesson
import com.brightsprouts.design.components.LessonCard
import com.brightsprouts.design.dimensions.BrightSproutsDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonPlayerScreen(
    lesson: Lesson,
    onAnswerSelected: (Int) -> Unit = {},
    onLessonComplete: () -> Unit = {},
    onNavigateBack: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var currentCardIndex by remember { mutableStateOf(0) }
    val currentCard = lesson.cards.getOrNull(currentCardIndex)
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = lesson.title,
                        style = MaterialTheme.typography.titleLarge
                    ) 
                },
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
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(BrightSproutsDimensions.spacingM)
        ) {
            // Progress indicator
            LinearProgressIndicator(
                progress = { (currentCardIndex + 1).toFloat() / lesson.cards.size.toFloat() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = BrightSproutsDimensions.spacingM)
            )
            
            Text(
                text = "Card ${currentCardIndex + 1} of ${lesson.cards.size}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = BrightSproutsDimensions.spacingL)
            )
            
            // Current card
            currentCard?.let { card ->
                LessonCard(
                    card = card,
                    onAnswerSelected = { answerIndex ->
                        onAnswerSelected(answerIndex)
                        if (currentCardIndex < lesson.cards.size - 1) {
                            currentCardIndex++
                        } else {
                            onLessonComplete()
                        }
                    }
                )
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Navigation buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { 
                        if (currentCardIndex > 0) {
                            currentCardIndex--
                        }
                    },
                    enabled = currentCardIndex > 0
                ) {
                    Text("Previous")
                }
                
                Button(
                    onClick = {
                        if (currentCardIndex < lesson.cards.size - 1) {
                            currentCardIndex++
                        } else {
                            onLessonComplete()
                        }
                    }
                ) {
                    Text(
                        if (currentCardIndex < lesson.cards.size - 1) "Next" else "Complete"
                    )
                }
            }
        }
    }
}
