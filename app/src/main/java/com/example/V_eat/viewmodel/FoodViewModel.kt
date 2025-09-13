package com.example.V_eat.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.V_eat.model.Dish
import com.example.V_eat.model.UserStats
import com.example.V_eat.repository.FoodRepository
import kotlinx.coroutines.launch

class FoodViewModel(
    // using fake repo by default for quick demo; replace with real repo if available
    private val repo: Any = FoodRepository()
) : ViewModel() {

    // state
    val dishes = mutableStateOf<List<Dish>>(emptyList())
    val stats = mutableStateOf(UserStats())
    val isLoading = mutableStateOf(false)

    // quick type-safe wrappers (because repo can be FakeFoodRepository or FoodRepository)
    private fun repoSafe() = when (repo) {
        is FoodRepository -> repo

        else -> throw IllegalStateException("Replace with real repo usage or pass FakeFoodRepository")
    }

    fun search(query: String) {
        viewModelScope.launch {
            isLoading.value = true
            // for demo we use fake repo
            val results = repoSafe().searchFood(query)
            dishes.value = results
            isLoading.value = false
        }
    }

    fun addToTracker(dish: Dish) {
        val newCalories = stats.value.totalCalories + (dish.calories ?: 0)
        val newSavings = stats.value.totalSavings + dish.savings
        stats.value = stats.value.copy(totalCalories = newCalories, totalSavings = newSavings)
    }

    fun increaseStreak() {
        stats.value = stats.value.copy(streakDays = stats.value.streakDays + 1)
    }

}


