package com.example.jetdisher.repositories.network

import com.example.jetdisher.data.models.CategortResponse.CategoryResponse
import retrofit2.http.GET

interface CategoriesService {

    @GET("categories.php")
    suspend fun getAllCategories(): CategoryResponse
}