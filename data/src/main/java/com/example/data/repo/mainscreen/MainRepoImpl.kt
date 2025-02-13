package com.example.data.repo.mainscreen

import com.example.data.remote.mainscreen.MealsApi
import com.example.domain.entity.mainscreen.MealModelItems
import com.example.domain.repo.mainscreen.MainScreenRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MainRepoImpl constructor(private val mealsApi: MealsApi) : MainScreenRepo {
    override suspend fun getMealsFromeRemote(): MealModelItems = mealsApi.getMeals()
}