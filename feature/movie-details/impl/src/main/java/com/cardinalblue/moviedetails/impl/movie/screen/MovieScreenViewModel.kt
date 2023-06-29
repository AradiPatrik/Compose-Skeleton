package com.cardinalblue.moviedetails.impl.movie.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.cardinalblue.domain.Movie
import com.cardinalblue.moviedetails.api.MovieDetailsInput
import com.cardinalblue.moviedetails.api.MovieDetailsOutput
import com.cardinalblue.moviedetails.impl.common.reviews.usecase.GetReviews
import com.cardinalblue.moviedetails.impl.directions.MovieDetailsDirections.Credits
import com.cardinalblue.moviedetails.impl.movie.usecase.GetMovie
import com.cardinalblue.navigation.AssistedViewModelFactory
import com.cardinalblue.navigation.NavigationManager
import com.cardinalblue.navigation.setResult
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield
import logcat.logcat
import java.util.UUID

class MovieScreenViewModel @AssistedInject constructor(
    private val getMovie: GetMovie,
    getReviews: GetReviews,
    @Assisted private val input: MovieDetailsInput,
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val navigationManager: NavigationManager,
) : ViewModel() {
    @AssistedFactory
    interface Factory : AssistedViewModelFactory<MovieDetailsInput, MovieScreenViewModel>

    val movie = MutableStateFlow<Movie?>(null)
    val reviews = getReviews(input.movieId).cachedIn(viewModelScope)
        .onStart { logcat("APDEBUG") { "Reviews flow started" } }
        .onCompletion { logcat("APDEBUG") { "Reviews flow completed" } }

    init {
        logcat("APDEBUG") { "Details screen init $this" }
        viewModelScope.launch {
            movie.value = getMovie(input.movieId)
            withContext(Dispatchers.IO) {
                delay(2000)
            }
            logcat("APDEBUG") { "View model scope: ${viewModelScope.isActive}"}
            yield()
            navigationManager.setResult(MovieDetailsOutput(UUID.randomUUID().toString()))
            logcat("APDEBUG") { "View model scope: ${viewModelScope.isActive}"}
            yield()
            navigationManager.navigateBack()
        }
    }

    fun onCreditsClicked() {
        navigationManager.navigate(
            Credits.destination(MovieDetailsInput(input.movieId))
        )
    }

    override fun onCleared() {
        super.onCleared()
        logcat("APDEBUG") { "Details screen cleared $this" }
    }
}
