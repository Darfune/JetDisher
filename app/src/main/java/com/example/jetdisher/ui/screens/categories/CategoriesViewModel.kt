package com.example.jetdisher.ui.screens.categories

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetdisher.data.remote.models.categories.Category
import com.example.jetdisher.domain.usecases.categories.IGetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    useCase: IGetCategoriesUseCase
) : ViewModel() {

    private val _listOfCategories: MutableState<List<Category>> = mutableStateOf(emptyList())
    val listOfCategories: State<List<Category>> = _listOfCategories

    init {
        viewModelScope.launch {
            _listOfCategories.value = useCase.getAllCategories().categories
        }
    }
}