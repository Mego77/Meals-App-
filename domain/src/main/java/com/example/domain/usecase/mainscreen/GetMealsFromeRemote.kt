package com.example.domain.usecase.mainscreen

import com.example.domain.repo.mainscreen.MainScreenRepo

class GetMealsFromeRemote (private val mainScreenRepo: MainScreenRepo){

    suspend operator fun invoke() = mainScreenRepo.getMealsFromeRemote()
}