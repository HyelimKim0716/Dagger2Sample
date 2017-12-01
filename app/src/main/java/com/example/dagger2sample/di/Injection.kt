package com.example.dagger2sample.di

import com.example.dagger2sample.data.*

/**
 * Created by Owner on 2017-11-29.
 */
class Injection {
    companion object {
        fun provideHeater(): Heater = HeaterA()
        fun providePump(): Pump = PumpA(provideHeater())
        fun provideCoffeeMaker(): CoffeeMaker = CoffeeMaker(provideHeater(), providePump())
    }
}