package com.example.jetdisher.domain.repositories.network

import com.example.jetdisher.data.remote.models.categories.CategoryResponse
import retrofit2.http.GET

interface CategoriesService {

    @GET("categories.php")
    suspend fun getAllCategories(): CategoryResponse
}