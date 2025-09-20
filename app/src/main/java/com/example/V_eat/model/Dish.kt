package com.example.V_eat.model

data class Dish(
    val name: String,
    val priceSwiggy: Double? = null,
    val priceZomato: Double? = null,
    val calories: Int? = null,
    val bestDeal: Boolean = false,
    val savings: Double = 0.0,
    val imageUrl: String? = null // Added imageUrl property
)