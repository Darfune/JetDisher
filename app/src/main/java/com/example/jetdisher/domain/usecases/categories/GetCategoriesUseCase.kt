package com.example.jetdisher.domain.usecases.categories

import com.example.jetdisher.data.remote.models.CategortResponse.CategoryResponse
import com.example.jetdisher.data.remote.repositories.InterfaceCategoriesRepository
import javax.inject.Inject

interface InterfaceGetCategoriesUseCase {
    suspend fun getAllCategories(): CategoryResponse
}


class GetCategoriesUseCase @Inject constructor(
    val repository: InterfaceCategoriesRepository
): InterfaceGetCategoriesUseCase {
    override suspend fun getAllCategories(): CategoryResponse {
        return repository.getAllCategories()
    }
}