package com.example.jetdisher.data.remote.repositories

import com.example.jetdisher.data.remote.models.categories.CategoryResponse
import com.example.jetdisher.domain.repositories.network.CategoriesService
import javax.inject.Inject

interface ICategoriesRepository{
    suspend fun getAllCategories() : CategoryResponse
}
class CategoriesRepository @Inject constructor(
    val service: CategoriesService
): ICategoriesRepository {
    override suspend fun getAllCategories(): CategoryResponse = service.getAllCategories()

}