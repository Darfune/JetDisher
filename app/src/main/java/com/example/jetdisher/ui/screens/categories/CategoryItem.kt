package com.example.jetdisher.ui.screens.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.jetdisher.data.remote.models.categories.Category

@Composable
fun CategoryItem(category: Category, categoryClicked: (String) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clickable { categoryClicked(category.strCategory)  },
        shape = RoundedCornerShape(25.dp),
        tonalElevation = 1.dp,
    ){

        Row(modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Surface(tonalElevation = 3.dp, shape = RoundedCornerShape(25.dp)) {
                AsyncImage(
                    model = category.strCategoryThumb,
                    contentDescription = "Category Image",
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .padding(4.dp)
                )
            }
            Text(text = category.strCategory, modifier = Modifier.padding(start = 16.dp))
        }
    }
}