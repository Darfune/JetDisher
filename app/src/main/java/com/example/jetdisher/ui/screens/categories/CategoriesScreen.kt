package com.example.jetdisher.ui.screens.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CategoriesScreen(
   viewModel: CategoriesViewModel  = hiltViewModel()
) {
   val listOfCategories by remember {
      viewModel.listOfCategories
   }
   Column {
      LazyColumn {
         items(listOfCategories){ category ->
            CategoryItem(category = category)
         }
      }
   }
}
