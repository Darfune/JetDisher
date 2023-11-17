package com.example.jetdisher.ui.screens.dishes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.jetdisher.data.remote.models.dishes.filtereddishes.Meal
import com.example.jetdisher.domain.usecases.dishes.IGetDishesFromCategoryUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


sealed class ViewState {
    object Loading : ViewState()
    data class Success(val data: List<Meal>) : ViewState()
    data class Error(val message: String) : ViewState()
}


class DishesViewModel @AssistedInject constructor(
    val useCase: IGetDishesFromCategoryUseCase,
    @Assisted private val categoryName: String
) : ViewModel() {


    private val _viewState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.Loading)
    val viewState: StateFlow<ViewState> = _viewState.asStateFlow()

    init {
        getDishesFromCategory(categoryName)
    }

    private fun getDishesFromCategory(categoryName: String) {
        _viewState.value = ViewState.Loading
        viewModelScope.launch {
            try {
                _viewState.value = ViewState.Success(useCase(categoryName).meals)
            } catch (e: Exception) {
                _viewState.value = ViewState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}


@Suppress("UNCHECKED_CAST")
class DishesViewModelFactory(
    private val categoryName: String,
    private val assistedFactory: DishesAssistedFactory
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return assistedFactory.create(categoryName) as T
    }
}

@AssistedFactory
interface DishesAssistedFactory {
    fun create(categoryName: String): DishesViewModel
}