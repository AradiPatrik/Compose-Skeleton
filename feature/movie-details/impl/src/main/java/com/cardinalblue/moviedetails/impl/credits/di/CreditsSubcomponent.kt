package com.cardinalblue.moviedetails.impl.credits.di

import com.cardinalblue.moviedetails.impl.credits.screen.CreditsScreenViewModel
import com.cardinalblue.navigation.SubfeatureScoped
import dagger.Subcomponent

@SubfeatureScoped
@Subcomponent(
    modules = [CreditsModule::class]
)
interface CreditsSubcomponent {
    val viewModel: CreditsScreenViewModel

    @Subcomponent.Factory
    interface Factory {
        fun create(): CreditsSubcomponent
    }
}