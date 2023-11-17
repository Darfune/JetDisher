package com.example.jetdisher.di

import com.example.jetdisher.domain.repositories.network.CategoriesService
import com.example.jetdisher.data.remote.repositories.CategoriesRepository
import com.example.jetdisher.data.remote.repositories.DishesFromCategoryRepository
import com.example.jetdisher.data.remote.repositories.ICategoriesRepository
import com.example.jetdisher.data.remote.repositories.IDishesFromCategoryRepository
import com.example.jetdisher.domain.repositories.network.DishesFromCategoryService
import com.example.jetdisher.domain.usecases.categories.GetCategoriesUseCase
import com.example.jetdisher.domain.usecases.categories.IGetCategoriesUseCase
import com.example.jetdisher.domain.usecases.dishes.GetDishesFromCategoryUseCase
import com.example.jetdisher.domain.usecases.dishes.IGetDishesFromCategoryUseCase
import com.example.jetdisher.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
//        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideDishesFromCategoryService(retrofit: Retrofit): DishesFromCategoryService =
        retrofit.create(DishesFromCategoryService::class.java)

    @Provides
    @Singleton
    fun providesCategoriesService(retrofit: Retrofit): CategoriesService =
        retrofit.create(CategoriesService::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInterface {

        @Binds
        @Singleton
        fun provideCategoriesRepository(
            repository: CategoriesRepository
        ): ICategoriesRepository

        @Binds
        @Singleton
        fun provideGetCategoriesUseCase(useCase: GetCategoriesUseCase): IGetCategoriesUseCase

        @Binds
        @Singleton
        fun provideDishesFromCategoryRepository(
            repository: DishesFromCategoryRepository
        ): IDishesFromCategoryRepository

        @Binds
        @Singleton
        fun provideGetDishesFromCategoryUseCase(useCase: GetDishesFromCategoryUseCase): IGetDishesFromCategoryUseCase
    }
}