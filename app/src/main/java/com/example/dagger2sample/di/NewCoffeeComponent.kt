package com.example.dagger2sample.di

import com.example.dagger2sample.data.CoffeeBean
import com.example.dagger2sample.data.CoffeeMaker
import com.example.dagger2sample.data.NewCoffeeMaker
import dagger.Subcomponent
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by Owner on 2017-12-01.
 */
@CoffeeScope
@Subcomponent(modules = arrayOf(NewCoffeeModule::class))
interface NewCoffeeComponent {
    fun coffeeMaker(): NewCoffeeMaker

    fun coffeeBean() : CoffeeBean

    @Subcomponent.Builder
    interface Builder {
        fun build(): NewCoffeeComponent
    }
}