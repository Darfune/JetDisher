package com.example.jetdisher.data.remote.repositories

import com.example.jetdisher.data.remote.models.CategortResponse.CategoryResponse
import com.example.jetdisher.domain.repositories.network.CategoriesService
import javax.inject.Inject

interface InterfaceCategoriesRepository{
    suspend fun getAllCategories() : CategoryResponse
}
class CategoriesRepository @Inject constructor(
    val service: CategoriesService
): InterfaceCategoriesRepository {
    override suspend fun getAllCategories(): CategoryResponse = service.getAllCategories()

}