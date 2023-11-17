package com.example.jetdisher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.jetdisher.ui.screens.categories.CategoriesViewModel
import com.example.jetdisher.ui.screens.dishes.DishesAssistedFactory
import com.example.jetdisher.ui.screens.dishes.DishesViewModel
import com.example.jetdisher.ui.navigation.DisherNavigation
import com.example.jetdisher.ui.theme.JetDisherTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var dishesAssistedFactory: DishesAssistedFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetDisherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JetDisherApp()
                }
            }
        }

    }

    @Composable
    fun JetDisherApp() {
        val categoriesViewModel: CategoriesViewModel = viewModel()
        val navController = rememberNavController()
        DisherNavigation(
            categoriesViewModel = categoriesViewModel,
            dishesAssistedFactory = dishesAssistedFactory,
            navController = navController
        )
    }
}

