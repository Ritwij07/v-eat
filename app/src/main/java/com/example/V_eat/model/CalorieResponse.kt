

package com.example.V_eat.model

data class CalorieResponse(
    val items: List<CalorieItem>?
)

data class CalorieItem(
    val name: String?,
    val calories: Int?
)
