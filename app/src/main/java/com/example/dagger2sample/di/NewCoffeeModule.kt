package com.example.dagger2sample.di

import com.example.dagger2sample.data.CoffeeBean
import com.example.dagger2sample.data.Heater
import com.example.dagger2sample.data.HeaterA
import com.example.dagger2sample.data.NewCoffeeMaker
import dagger.Module
import dagger.Provides

/**
 * Created by Owner on 2017-12-01.
 */
@Module
class NewCoffeeModule {
    @CoffeeScope @Provides fun provideCoffeeMaker(heater: Heater) : NewCoffeeMaker = NewCoffeeMaker(heater)

    @CoffeeScope @Provides fun provideHeater(): Heater = HeaterA()

    @Provides fun provideBean(): CoffeeBean = CoffeeBean()
}