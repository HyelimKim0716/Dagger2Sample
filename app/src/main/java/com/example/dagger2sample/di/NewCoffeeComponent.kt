package com.example.dagger2sample.di

import com.example.dagger2sample.data.CoffeeBean
import com.example.dagger2sample.data.CoffeeMaker
import dagger.Subcomponent

/**
 * Created by Owner on 2017-12-01.
 */
@Subcomponent(modules = arrayOf(CoffeeMakerModule::class))
interface NewCoffeeComponent {
    fun coffeeMaker(): CoffeeMaker

    fun coffeeBean() : CoffeeBean

    @Subcomponent.Builder
    interface Builder {
        fun build(): NewCoffeeComponent
    }
}