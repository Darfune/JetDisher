package com.example.jetdisher.domain.usecases.categories

import com.example.jetdisher.data.remote.models.categories.CategoryResponse
import com.example.jetdisher.data.remote.repositories.ICategoriesRepository
import javax.inject.Inject

interface IGetCategoriesUseCase {
    suspend fun getAllCategories(): CategoryResponse
}


class GetCategoriesUseCase @Inject constructor(
    val repository: ICategoriesRepository
): IGetCategoriesUseCase {
    override suspend fun getAllCategories(): CategoryResponse = repository.getAllCategories()
}