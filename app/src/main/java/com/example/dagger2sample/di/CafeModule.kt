package com.example.dagger2sample.di

import com.example.dagger2sample.data.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Owner on 2017-12-01.
 */
@Module
class CafeModule {
    @Singleton @Provides fun provideCafeInfo(): CafeInfo = CafeInfo("Knowbie's Cafe")

    @Provides fun provideNewCoffeeMaker(heater: Heater): NewCoffeeMaker = NewCoffeeMaker(heater)

    @Provides fun provideHeater() : Heater = HeaterA()
}