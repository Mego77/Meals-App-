package com.example.mealsappodcgroupd

import okhttp3.Route



sealed class Screen(val route : String){
    object MainScreen : Screen("mainScreen")
    object MealDetailsScreen : Screen("mealDetailsScreen")
}