package com.example.jetdisher.ui.screens.categories

import com.example.jetdisher.data.models.CategortResponse.CategoryResponse
import com.example.jetdisher.repositories.remote.InterfaceCategoriesRepository
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