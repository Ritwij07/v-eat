package com.example.V_eat.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.V_eat.model.Dish
import com.example.V_eat.viewmodel.FoodViewModel
import com.example.V_eat.ui.components.DishCard

@Composable
fun HomeScreen(viewModel: FoodViewModel = viewModel()) {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search dish") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { viewModel.search(searchQuery) }) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (viewModel.isLoading.value) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(viewModel.dishes.value) { dish ->
                DishCard(dish = dish, onTrack = { viewModel.addToTracker(dish) })
            }
        }
    }
}