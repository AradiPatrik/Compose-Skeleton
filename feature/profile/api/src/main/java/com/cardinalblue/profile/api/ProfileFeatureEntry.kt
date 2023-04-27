package com.cardinalblue.profile.api

import androidx.navigation.NamedNavArgument
import com.cardinalblue.navigation.EmptyInput
import com.cardinalblue.navigation.FeatureEntry
import com.cardinalblue.navigation.NavigationCommand
import com.cardinalblue.navigation.NavigationCommandProvider

abstract class ProfileFeatureEntry : FeatureEntry<EmptyInput> {
    companion object : NavigationCommandProvider<EmptyInput> {
        override val featureRoute: String = "profile"

        override val arguments: List<NamedNavArgument> = emptyList()

        override fun destination(input: EmptyInput): NavigationCommand =
            object : NavigationCommand {
                override val arguments: List<NamedNavArgument> = this@Companion.arguments
                override val destinationFeatureRoute: String = featureRoute
                override val destination: String = featureRoute
            }
    }
}