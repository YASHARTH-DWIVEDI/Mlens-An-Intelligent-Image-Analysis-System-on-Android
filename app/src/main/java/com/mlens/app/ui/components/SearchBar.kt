package com.mlens.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mlens.app.viewmodels.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    onQueryChange: (String) -> Unit,
    onFilterChange: (MainViewModel.FilterType) -> Unit,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf(MainViewModel.FilterType.ALL) }
    var expanded by remember { mutableStateOf(false) }
    
    Column(modifier = modifier) {
        OutlinedTextField(
            value = query,
            onValueChange = { 
                query = it
                onQueryChange(it)
            },
            label = { Text("Search images...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Filter chips
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedFilter == MainViewModel.FilterType.ALL,
                onClick = { 
                    selectedFilter = MainViewModel.FilterType.ALL
                    onFilterChange(MainViewModel.FilterType.ALL)
                },
                label = { Text("All") }
            )
            FilterChip(
                selected = selectedFilter == MainViewModel.FilterType.TEXT,
                onClick = { 
                    selectedFilter = MainViewModel.FilterType.TEXT
                    onFilterChange(MainViewModel.FilterType.TEXT)
                },
                label = { Text("Text") }
            )
            FilterChip(
                selected = selectedFilter == MainViewModel.FilterType.VISUAL,
                onClick = { 
                    selectedFilter = MainViewModel.FilterType.VISUAL
                    onFilterChange(MainViewModel.FilterType.VISUAL)
                },
                label = { Text("Visual") }
            )
        }
    }
}