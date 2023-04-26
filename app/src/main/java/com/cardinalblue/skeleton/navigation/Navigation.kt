package com.cardinalblue.skeleton.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.cardinalblue.moviesearch.api.MovieSearchFeatureEntry
import com.cardinalblue.navigation.CompositionLocals
import com.cardinalblue.navigation.FeatureEntriesProvider
import com.cardinalblue.navigation.addFeatureEntry
import com.cardinalblue.navigation.find
import com.cardinalblue.profile.api.ProfileFeatureEntry

@Composable
fun App(navController: NavController) {
    Scaffold(
        bottomBar = { MovieDbBottomAppBar() },
        content = { paddingValues ->
            NavGraph(paddingValues, navController)
        }
    )
}

@Composable
fun NavGraph(paddingValues: PaddingValues, navController: NavController) {
    val featureEntries = CompositionLocals.current<FeatureEntriesProvider>().featureEntries
    val movieSearchEntry = featureEntries.find<MovieSearchFeatureEntry>()
    val profileEntry = featureEntries.find<ProfileFeatureEntry>()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        NavHost(
            navController as NavHostController,
            startDestination = "@movie-search"
        ) {
            addFeatureEntry(navController, movieSearchEntry)
            addFeatureEntry(navController, profileEntry)
        }
    }
}
