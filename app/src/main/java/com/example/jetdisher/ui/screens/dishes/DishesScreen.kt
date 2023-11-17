package com.example.jetdisher.ui.screens.dishes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DishesScreen(
    dishesAssistedFactory: DishesAssistedFactory,
    category: String,
) {
    val viewModel = viewModel(
        modelClass = DishesViewModel::class.java,
        factory = DishesViewModelFactory(
            categoryName = category,
            assistedFactory = dishesAssistedFactory
        )
    )
    val viewState = viewModel.viewState.collectAsState()
    when (viewState.value) {
        is ViewState.Success-> {
            Text(text = "${viewState.value}")
        }

        is ViewState.Loading -> {}
        is ViewState.Error -> {}
    }

}


@Composable
fun DishesUi() {

}