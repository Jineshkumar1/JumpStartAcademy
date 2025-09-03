package com.brightsprouts.tv.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brightsprouts.design.dimensions.BrightSproutsDimensions

@Composable
fun TvSettingsScreen(
    onNavigateBack: () -> Unit
) {
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
                text = "Settings",
                style = MaterialTheme.typography.displayMedium
            )
        }
        
        Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingXL))
        
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(BrightSproutsDimensions.spacingL)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(BrightSproutsDimensions.spacingL)
                    ) {
                        Text(
                            text = "App Settings",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingM))
                        
                        // Sound settings
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Sound Effects")
                            Switch(
                                checked = true,
                                onCheckedChange = { /* TODO: Implement sound toggle */ }
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingM))
                        
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Background Music")
                            Switch(
                                checked = false,
                                onCheckedChange = { /* TODO: Implement music toggle */ }
                            )
                        }
                    }
                }
            }
            
            item {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(BrightSproutsDimensions.spacingL)
                    ) {
                        Text(
                            text = "About",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingM))
                        
                        Text(
                            text = "JumpStartAcademy TV v1.0.0",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(BrightSproutsDimensions.spacingS))
                        
                        Text(
                            text = "A fun learning app for kids ages 3-6 on Android TV",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}
