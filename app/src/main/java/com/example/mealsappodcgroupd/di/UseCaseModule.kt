package com.example.mealsappodcgroupd.di

import com.example.domain.repo.mainscreen.MainScreenRepo
import com.example.domain.usecase.mainscreen.GetMealsFromeRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    //Main
    @Provides
    fun provideGetMealsFromRemoteUseCase(mainRepo: MainScreenRepo): GetMealsFromeRemote {
        return GetMealsFromeRemote(mainRepo)
        }
}