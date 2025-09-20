package com.example.V_eat.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import coil.compose.AsyncImage
import com.example.V_eat.model.Dish

@Composable
fun DishCard(dish: Dish, onTrack: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (dish.bestDeal) Color(0xFFDFFFD6) else Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = dish.name, style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(6.dp))
            Text(text = "Swiggy: ${dish.priceSwiggy?.let { "₹$it" } ?: "-"}")
            Text(text = "Zomato: ${dish.priceZomato?.let { "₹$it" } ?: "-"}")
            if (dish.savings > 0.0) {
                Text(
                    text = "💰 You save ₹${dish.savings}",
                    color = Color(0xFF006400)
                )
            }
            Text(text = "Calories: ${dish.calories ?: "?"} kcal")
            Spacer(Modifier.height(8.dp))
            Button(onClick = onTrack) {
                Text("Add to Tracker")
            }
        }
    }

}

