package com.example.jetdisher.repositories.remote

import com.example.jetdisher.data.models.CategortResponse.CategoryResponse
import com.example.jetdisher.repositories.network.CategoriesService
import javax.inject.Inject

interface InterfaceCategoriesRepository{
    suspend fun getAllCategories() : CategoryResponse
}
class CategoriesRepository @Inject constructor(
    val service: CategoriesService
): InterfaceCategoriesRepository {
    override suspend fun getAllCategories(): CategoryResponse = service.getAllCategories()

}