package com.example.dagger2sample.di

import com.example.dagger2sample.CoffeeMaker
import dagger.Component

/**
 * Created by Owner on 2017-11-29.
 *
 * @Component class has to have one abstract method at least, and you can create DI with this class
 */
@Component(modules = arrayOf(CoffeeMakerModule::class))
interface CoffeeComponent {

    // provision method
    fun make(): CoffeeMaker

    // member-injection method
    fun inject(coffeeMaker: CoffeeMaker)
}