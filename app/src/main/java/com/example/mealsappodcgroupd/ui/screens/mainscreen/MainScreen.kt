package com.example.mealsappodcgroupd.ui.screens.mainscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Preview(showBackground = true , showSystemUi = true)

@Composable
fun MainScreen(navController: NavController ? = null , viewmodel: MainViewModel= hiltViewModel() ) {


   val meals by viewmodel.meals.collectAsState()

  Box(modifier = Modifier.fillMaxSize().padding(15.dp)) {
     LazyColumn (modifier = Modifier.fillMaxSize()) {
      items(meals.categories){
         MealItem(title = it.strCategory ?:"" , imageUrl = it.strCategoryThumb ?:""  ) {
             navController?.navigate("mealDetailsScreen")
         }

      }

     }

  }



}

