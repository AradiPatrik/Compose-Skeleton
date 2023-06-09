package com.cardinalblue.skeleton.di

import com.cardinalblue.data.api.DataProvider
import com.cardinalblue.navigation.FeatureEntriesProvider
import com.cardinalblue.navigation.NavigationProvider
import com.cardinalblue.platform.PlatformProvider
import com.cardinalblue.skeleton.AppViewModel

interface AppProvider : PlatformProvider, DataProvider, FeatureEntriesProvider {
    val navigationSubcomponentFactory: NavigationSubcomponent.Factory
}
