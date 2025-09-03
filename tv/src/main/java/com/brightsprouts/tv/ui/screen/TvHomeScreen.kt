package com.brightsprouts.tv.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brightsprouts.design.dimensions.BrightSproutsDimensions
import com.brightsprouts.design.theme.BrightSproutsTheme

@Composable
fun TvHomeScreen(
    onNavigateToMath: () -> Unit,
    onNavigateToEnglish: () -> Unit,
    onNavigateToAnimals: () -> Unit,
    onNavigateToKg: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    val categories = listOf(
        TvCategoryItem("Math", "🔢", "Learn numbers and counting", onNavigateToMath),
        TvCategoryItem("English", "📚", "Learn letters and words", onNavigateToEnglish),
        TvCategoryItem("Animals", "🐾", "Discover amazing animals", onNavigateToAnimals),
        TvCategoryItem("KG Topics", "🌟", "Colors, shapes, and more", onNavigateToKg)
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(BrightSproutsDimensions.spacingXL)
    ) {
        // Header with title and settings
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "JumpStartAcademy",
                style = MaterialTheme.typography.displayMedium
            )
            IconButton(onClick = onNavigateToSettings) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            }
        }
        
        Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingL))
        
        Text(
            text = "Choose a subject to start learning",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = BrightSproutsDimensions.spacingXL)
        )
        
        // Category row
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(BrightSproutsDimensions.spacingL)
        ) {
            items(categories) { category ->
                TvCategoryCard(
                    category = category,
                    modifier = Modifier
                        .width(250.dp)
                        .height(200.dp)
                )
            }
        }
    }
}

@Composable
private fun TvCategoryCard(
    category: TvCategoryItem,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }
    
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    
    Card(
        modifier = modifier
            .focusRequester(focusRequester),
        onClick = category.onClick,
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
                text = category.emoji,
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingM))
            Text(
                text = category.title,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingS))
            Text(
                text = category.description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

private data class TvCategoryItem(
    val title: String,
    val emoji: String,
    val description: String,
    val onClick: () -> Unit
)