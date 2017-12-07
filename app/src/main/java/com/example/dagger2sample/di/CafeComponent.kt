package com.example.dagger2sample.di

import com.example.dagger2sample.data.CafeInfo
import com.example.dagger2sample.data.NewCoffeeMaker
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Owner on 2017-12-01.
 */
@Singleton
@Component (modules = arrayOf(CafeModule::class))
interface CafeComponent {
    fun cafeInfo() : CafeInfo

//    fun coffeeMaker() : NewCoffeeMaker

    fun coffeeComponent() : NewCoffeeComponent.Builder
}