package com.example.V_eat.repository



import com.example.V_eat.model.Dish
import com.example.V_eat.network.RetrofitInstance
import kotlin.math.abs

class FoodRepository {
    private val api = RetrofitInstance.api

    // Fetch from both platforms and merge by simple name matching
    suspend fun searchFood(query: String): List<Dish> {
        val swiggy = api.searchSwiggy(query).map { it.copy(platform = "Swiggy") }
        val zomato = api.searchZomato(query).map { it.copy(platform = "Zomato") }

        val dishes = mutableListOf<Dish>()

        // Simple matching: for every swiggy restaurant/dish try to find a matching name in zomato
        for (s in swiggy) {
            val match = zomato.find { z -> z.dishName?.contains(s.dishName ?: s.name, ignoreCase = true) == true }
            if (match != null) {
                val savings = abs(s.price - match.price)
                val bestDeal = s.price < match.price
                dishes.add(
                    Dish(
                        name = s.dishName ?: s.name,
                        priceSwiggy = s.price,
                        priceZomato = match.price,
                        calories = null,
                        bestDeal = bestDeal,
                        savings = savings
                    )
                )
            } else {
                // No match on zomato; still include swiggy item
                dishes.add(
                    Dish(
                        name = s.dishName ?: s.name,
                        priceSwiggy = s.price,
                        priceZomato = null
                    )
                )
            }
        }

        // Also include zomato-only items not matched
        for (z in zomato) {
            val has = dishes.any { d -> d.name.equals(z.dishName ?: z.name, ignoreCase = true) }
            if (!has) {
                dishes.add(Dish(name = z.dishName ?: z.name, priceSwiggy = null, priceZomato = z.price))
            }
        }

        return dishes
    }

    suspend fun getCalories(foodName: String): Int {
        val resp = RetrofitInstance.api.getCalories(foodName)
        return resp.items?.firstOrNull()?.calories ?: 0
    }
}
