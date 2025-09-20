package com.example.V_eat.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.V_eat.model.Dish

@Composable
fun DishCard(dish: Dish, onTrack: () -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(if (dish.bestDeal) Color(0xFFDFFFD6) else Color.White)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = dish.name, style = MaterialTheme.typography.h6)
            Spacer(Modifier.height(6.dp))
            Text(text = "Swiggy: ${dish.priceSwiggy?.let { "₹$it" } ?: "-"}")
            Text(text = "Zomato: ${dish.priceZomato?.let { "₹$it" } ?: "-"}")
            if (dish.savings > 0.0) {
                Text(text = "💰 You save ₹${dish.savings}", color = Color(0xFF006400))
            }
            Text(text = "Calories: ${dish.calories ?: "?"} kcal")
            Spacer(Modifier.height(8.dp))
            Button(onClick = onTrack) {
                Text("Add to Tracker")
            }
        }
    }
}
