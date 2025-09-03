package com.brightsprouts.design.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brightsprouts.core.domain.model.LessonCard as DomainLessonCard
import com.brightsprouts.core.domain.model.PromptCard
import com.brightsprouts.core.domain.model.ChoiceCard
import com.brightsprouts.design.dimensions.BrightSproutsDimensions

@Composable
fun LessonCard(
    card: DomainLessonCard,
    onAnswerSelected: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(BrightSproutsDimensions.radiusL),
        elevation = CardDefaults.cardElevation(defaultElevation = BrightSproutsDimensions.elevationM)
    ) {
        when (card) {
            is PromptCard -> PromptCardContent(card)
            is ChoiceCard -> ChoiceCardContent(card, onAnswerSelected)
            else -> {
                // Handle other card types
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Card type not implemented yet",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Composable
private fun PromptCardContent(
    card: PromptCard,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(BrightSproutsDimensions.spacingL),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = card.tts,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun ChoiceCardContent(
    card: ChoiceCard,
    onAnswerSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(BrightSproutsDimensions.spacingL),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Placeholder for image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "🖼️ ${card.image}",
                style = MaterialTheme.typography.displayMedium
            )
        }
        
        Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingM))
        
        // Answer options
        card.options.forEachIndexed { index, option ->
            Button(
                onClick = { onAnswerSelected(index) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = BrightSproutsDimensions.spacingXS)
            ) {
                Text(
                    text = option,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
