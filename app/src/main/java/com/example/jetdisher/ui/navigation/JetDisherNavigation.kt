package com.example.jetdisher.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetdisher.ui.screens.categories.CategoriesScreen
import com.example.jetdisher.ui.screens.categories.CategoriesViewModel
import com.example.jetdisher.ui.screens.details.DetailsScreen
import com.example.jetdisher.ui.screens.dishes.DishesAssistedFactory
import com.example.jetdisher.ui.screens.dishes.DishesScreen
import com.example.jetdisher.ui.screens.dishes.DishesViewModel

enum class DisherScreens {
    Categories, Dishes, Details
}

@Composable
fun DisherNavigation(
    navController: NavHostController,
    categoriesViewModel: CategoriesViewModel,
    dishesAssistedFactory: DishesAssistedFactory
) {
    NavHost(
        navController = navController,
        startDestination = DisherScreens.Categories.name
    ) {
        composable(route = DisherScreens.Categories.name) {
            CategoriesScreen() { category ->
                navController.navigate("${DisherScreens.Dishes.name}/$category")
            }
        }
        composable(
            route = "${DisherScreens.Dishes.name}/{category}",
            arguments = listOf(navArgument(name = "category") {
                type = NavType.StringType
                defaultValue = ""
            })
        ) {navBackStackEntry ->
            val categoryArg = remember {
                navBackStackEntry.arguments?.getString("category") ?: ""
            }
            DishesScreen(category = categoryArg, dishesAssistedFactory = dishesAssistedFactory)
        }
        composable(route = DisherScreens.Details.name) {
            DetailsScreen()
        }
    }

}