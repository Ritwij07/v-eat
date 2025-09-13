package com.example.V_eat.model



data class Restaurant(
    val id: String? = null,
    val name: String,
    val dishName: String? = null,
    val price: Double,
    val lat: Double? = null,
    val lng: Double? = null,
    val rating: Double? = null,
    val platform: String? = null // "Swiggy" or "Zomato"
)
