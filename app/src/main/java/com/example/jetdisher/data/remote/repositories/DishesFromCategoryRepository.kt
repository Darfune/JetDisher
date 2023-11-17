package com.example.jetdisher.data.remote.repositories

import com.example.jetdisher.data.remote.models.dishes.filtereddishes.FilteredDishesResponse
import com.example.jetdisher.domain.repositories.network.DishesFromCategoryService
import javax.inject.Inject

interface IDishesFromCategoryRepository{
    suspend fun getDishesFromCategory(categoryName: String): FilteredDishesResponse
}

class DishesFromCategoryRepository @Inject constructor(
    val service: DishesFromCategoryService
): IDishesFromCategoryRepository{
    override suspend fun getDishesFromCategory(categoryName: String): FilteredDishesResponse =
        service.getDishesFromCategory(categoryName = categoryName)

}