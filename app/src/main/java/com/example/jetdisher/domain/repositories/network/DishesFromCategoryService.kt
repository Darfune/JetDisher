package com.example.jetdisher.domain.repositories.network

import com.example.jetdisher.data.remote.models.dishes.filtereddishes.FilteredDishesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DishesFromCategoryService {
    @GET("filter.php")
    suspend fun getDishesFromCategory(@Query("c") categoryName: String): FilteredDishesResponse
}