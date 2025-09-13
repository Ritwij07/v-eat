package com.example.V_eat.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.V_eat.model.Dish
import com.example.V_eat.viewmodel.FoodViewModel
import com.example.V_eat.ui.components.DishCard

@Composable
fun HomeScreen(viewModel: FoodViewModel, openTracker: () -> Unit) {
    var query by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search dish (e.g. Paneer Butter Masala)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Button(onClick = { viewModel.search(query) }, modifier = Modifier.weight(1f)) {
                Text("Search")
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = openTracker, modifier = Modifier.weight(1f)) {
                Text("Open Tracker")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (viewModel.isLoading.value) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.dishes.value) { dish ->
                DishCard(dish = dish, onTrack = { viewModel.addToTracker(dish) })
            }
        }
    }
}


