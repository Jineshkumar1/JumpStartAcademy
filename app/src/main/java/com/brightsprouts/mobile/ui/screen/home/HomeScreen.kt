package com.brightsprouts.mobile.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
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
fun HomeScreen(
    onNavigateToMath: () -> Unit,
    onNavigateToEnglish: () -> Unit,
    onNavigateToAnimals: () -> Unit,
    onNavigateToKg: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    val categories = listOf(
        CategoryItem("Math", "🔢", "Learn numbers and counting", onNavigateToMath),
        CategoryItem("English", "📚", "Learn letters and words", onNavigateToEnglish),
        CategoryItem("Animals", "🐾", "Discover amazing animals", onNavigateToAnimals),
        CategoryItem("KG Topics", "🌟", "Colors, shapes, and more", onNavigateToKg)
    )
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "JumpStartAcademy",
                        style = MaterialTheme.typography.headlineMedium
                    ) 
                },
                actions = {
                    IconButton(onClick = onNavigateToSettings) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(BrightSproutsDimensions.spacingM)
        ) {
            // Welcome message
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = BrightSproutsDimensions.spacingL)
            ) {
                Column(
                    modifier = Modifier.padding(BrightSproutsDimensions.spacingL),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Welcome to JumpStartAcademy! 🚀",
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingS))
                    Text(
                        text = "Choose a subject to start learning",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            // Category grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(BrightSproutsDimensions.spacingM),
                verticalArrangement = Arrangement.spacedBy(BrightSproutsDimensions.spacingM)
            ) {
                items(categories) { category ->
                    CategoryCard(
                        category = category,
                        modifier = Modifier.height(160.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun CategoryCard(
    category: CategoryItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = category.onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = BrightSproutsDimensions.elevationM)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(BrightSproutsDimensions.spacingM),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = category.emoji,
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingS))
            Text(
                text = category.title,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingXS))
            Text(
                text = category.description,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

private data class CategoryItem(
    val title: String,
    val emoji: String,
    val description: String,
    val onClick: () -> Unit
)
