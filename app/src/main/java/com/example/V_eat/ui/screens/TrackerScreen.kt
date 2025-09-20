package com.example.V_eat.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.V_eat.viewmodel.FoodViewModel

@Composable
fun TrackerScreen(viewModel: FoodViewModel, onBack: () -> Unit) {
    val stats = viewModel.stats.value

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🍴 Daily Summary", style = MaterialTheme.typography.h5)
        Spacer(Modifier.height(12.dp))

        Text("Calories Today: ${stats.totalCalories} / 2000 kcal")
        LinearProgressIndicator(progress = stats.totalCalories / 2000f, modifier = Modifier.fillMaxWidth().height(8.dp))
        Spacer(Modifier.height(12.dp))

        Text("💰 Money Saved: ₹${"%.2f".format(stats.totalSavings)}")
        Spacer(Modifier.height(12.dp))
        Text("🔥 Streak: ${stats.streakDays} days")
    }
}
