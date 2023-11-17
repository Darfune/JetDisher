package com.example.jetdisher.domain.usecases.dishes

import com.example.jetdisher.data.remote.models.dishes.filtereddishes.FilteredDishesResponse
import com.example.jetdisher.data.remote.repositories.IDishesFromCategoryRepository
import javax.inject.Inject

interface IGetDishesFromCategoryUseCase {
    suspend operator fun invoke(categoryName: String): FilteredDishesResponse
}

class GetDishesFromCategoryUseCase @Inject constructor(
    val repository: IDishesFromCategoryRepository
): IGetDishesFromCategoryUseCase{
    override suspend fun invoke(categoryName: String): FilteredDishesResponse =
        repository.getDishesFromCategory(categoryName)

}
