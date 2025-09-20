package com.example.V_eat.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.V_eat.viewmodel.FoodViewModel

@Composable
fun TrackerScreen(viewModel: FoodViewModel) {
    val stats = viewModel.stats.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🍴 Daily Summary", style = androidx.compose.material3.MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Calories Today: ${stats.totalCalories} / 2000 kcal")
        Spacer(modifier = Modifier.height(8.dp))

        Text("💰 Money Saved: ₹${"%.2f".format(stats.totalSavings)}")
        Spacer(modifier = Modifier.height(8.dp))

        Text("🔥 Streak: ${stats.streakDays} days")
    }
}