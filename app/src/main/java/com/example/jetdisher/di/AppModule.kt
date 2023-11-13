package com.example.jetdisher.di

import com.example.jetdisher.repositories.network.CategoriesService
import com.example.jetdisher.repositories.remote.CategoriesRepository
import com.example.jetdisher.repositories.remote.InterfaceCategoriesRepository
import com.example.jetdisher.ui.screens.categories.GetCategoriesUseCase
import com.example.jetdisher.ui.screens.categories.InterfaceGetCategoriesUseCase
import com.example.jetdisher.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
//        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providesCategoriesService(retrofit: Retrofit): CategoriesService =
        retrofit.create(CategoriesService::class.java)
    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInterface {

        @Binds
        @Singleton
        fun provideCategoriesRepository(
            repository: CategoriesRepository
        ): InterfaceCategoriesRepository

        @Binds
        @Singleton
        fun provideGetCategoriesUseCase(useCase: GetCategoriesUseCase): InterfaceGetCategoriesUseCase
    }
}