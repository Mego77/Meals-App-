package com.example.mealsappodcgroupd.ui.screens.mainscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.domain.entity.mainscreen.MealModelItems
import com.example.domain.usecase.mainscreen.GetMealsFromeRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

private const val TAG = "MainViewModel"
@HiltViewModel
class MainViewModel @Inject constructor(private val getMealsFromRemote: GetMealsFromeRemote) : ViewModel() {

    private val _meals = MutableStateFlow(MealModelItems(emptyList()))
    val meals = _meals.asStateFlow()

    init {
        getMeals()
    }

    private fun getMeals(){
        viewModelScope.launch {
            try {
                _meals.value = getMealsFromRemote()
                Log.d(TAG, "getMeals: ${Thread.currentThread().name}")

            }catch (e : Exception){
                if (e is HttpException){
                    Log.d(TAG, "HttpException getMeals: ${e.message}")
                }else{
                    Log.d(TAG, "Exception getMeals: ${e.message}")
                }
            }
        }
        }


}