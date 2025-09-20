package com.example.V_eat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

// Dummy data model
data class FoodItem(
    val name: String,
    val description: String,
    val price: String,
    val imageUrl: String
)

// Sample data list
val sampleFoods = listOf(
    FoodItem(
        "Paneer Butter Masala",
        "Rich & creamy North Indian curry",
        "₹220",
        "https://www.themealdb.com/images/media/meals/1529444830.jpg"
    ),
    FoodItem(
        "Chicken Biryani",
        "Spicy Hyderabadi biryani with raita",
        "₹300",
        "https://www.themealdb.com/images/media/meals/xrttsx1487339558.jpg"
    ),
    FoodItem(
        "Veggie Pizza",
        "Loaded with fresh vegetables & cheese",
        "₹180",
        "https://www.themealdb.com/images/media/meals/x0lk931587671540.jpg"
    )
)

@Composable
fun FoodListScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(sampleFoods) { food ->
            FoodItemCard(food)
        }
    }
}

@Composable
fun FoodItemCard(food: FoodItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize().padding(8.dp)
        ) {
            // Food Image
            AsyncImage(
                model = food.imageUrl,
                contentDescription = food.name,
                modifier = Modifier
                    .size(100.dp)
                    .padding(4.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Food Details
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = food.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(text = food.description, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                Text(text = food.price, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
            }

            // Favorite Icon
            IconButton(onClick = { /* TODO: Add fav functionality */ }) {
                Icon(
                    painter = painterResource(id = android.R.drawable.btn_star_big_off),
                    contentDescription = "Favorite",
                    tint = Color.Gray
                )
            }
        }
    }
}
