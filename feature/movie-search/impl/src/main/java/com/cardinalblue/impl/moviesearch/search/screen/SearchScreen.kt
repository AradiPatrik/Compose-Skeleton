package com.cardinalblue.impl.moviesearch.search.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cardinalblue.theme.SkeletonTheme

@Composable
fun SearchScreen(viewModel: SearchScreenViewModel) {
    SearchScreen(viewModel::onTitleClick)
}

@Composable
fun SearchScreen(onTitleClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
                    .clickable { onTitleClick() },
                text = "Search Screen",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SearchScreenPreview() {
    SkeletonTheme {
        SearchScreen(onTitleClick = {})
    }
}