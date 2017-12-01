package com.example.dagger2sample.di

import com.example.dagger2sample.data.CoffeeBean
import com.example.dagger2sample.data.Heater
import dagger.Module
import dagger.Provides

/**
 * Created by Owner on 2017-12-01.
 */
@Module
interface NewCoffeeModule {
    @Provides fun provideHeater(): Heater

    @Provides fun provideBean(): CoffeeBean
}