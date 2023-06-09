package com.cardinalblue.data.di

import com.cardinalblue.data.api.DataProvider
import com.cardinalblue.platform.PlatformProvider
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [PlatformProvider::class],
    modules = [DataModule::class, NetworkModule::class, StorageModule::class]
)
@Singleton
interface DataComponent : DataProvider