package com.example.dagger2sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dagger2sample.data.CoffeeBean
import com.example.dagger2sample.data.CoffeeMaker
import com.example.dagger2sample.data.HeaterA
import com.example.dagger2sample.data.PumpA
import com.example.dagger2sample.di.DaggerCoffeeComponent
import com.example.dagger2sample.di.DaggerCafeComponent
import com.example.dagger2sample.di.Injection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * Not using DI yet
        * To make coffee, coffeeMaker has to get heater and pump.
        * However, a person who wants to get doesn't need to know what heater and pump is used.
        * Therefore, user has to know that he or she depends on which objects.
        * */
        val heater = HeaterA()
        val pump = PumpA(heater)
        val coffeeMaker1 = CoffeeMaker(heater, pump)
        coffeeMaker1.brew()

        /*
        * DI let user to get coffee without CoffeeMaker dependency (which heater or pump instance)
        * Injection class is DI setting file.
        * Let's make a cup of coffee.
        * You can get heater and pump from Injection class, so you don't need to know which heater has to be used.
        * */
        val coffeeMaker2 = CoffeeMaker(Injection.provideHeater(), Injection.providePump())
        coffeeMaker2.brew()
        // or
        /*
        * CoffeeMaker doesn't need to notify which heater is used(HeaterA? HeaterB?) to user
        * */
        Injection.provideCoffeeMaker().brew()

        /*
        * <DI with Dagger>
        *     You can get DI using annotations of Dagger
        *     @Component
        *     @Module
        *     @Provides
        *     @Inject
        * */
        DaggerCoffeeComponent.create().make().brew()

//        val coffeeMaker3 = CoffeeMaker()
//        DaggerCoffeeComponent.create().inject(coffeeMaker3)
//        coffeeMaker3.brew()

        /*
        * You can get CafeInfo or get a cup of coffee with CafeComponent (the same as above CoffeeMakerComponent)
        */
        DaggerCafeComponent.create().cafeInfo().welcome()
//        DaggerCafeComponent.create().coffeeMaker().brew(CoffeeBean())

        /*
        * Adapt @Singleton  to CafeComponent
        * Cafe doesn't need to get CafeComponent and CafeInfo.
        * Make Singleton
        * cafeComponent1 = cafeComponent2
        * cafeInfo1 = cafeInfo2
        * coffeeMaker3 != coffeeMaker4
        * */
        val cafeComponent1 = DaggerCafeComponent.create()
        val cafeInfo1 = cafeComponent1.cafeInfo()
        val cafeInfo2 = cafeComponent1.cafeInfo()
        println("cafeInfo1 is same as cafeInfo2 ? ${cafeInfo1 == cafeInfo2}")

        val cafeComponent2 = DaggerCafeComponent.create()
//        val coffeeMaker3 = cafeComponent2.coffeeMaker()
//        val coffeeMaker4 = cafeComponent2.coffeeMaker()
//        println("coffeeMaker3 is same as coffeeMaker4 ? ${coffeeMaker3 == coffeeMaker4}")

        /*
        * Match CoffeeMaker and Heater
        * Make CoffeeCompoent
        * */

        // CoffeeScope
        val cafeComponent3 = cafeComponent1.coffeeComponent().build()
        val cafeComponent4 = cafeComponent1.coffeeComponent().build()
        val coffeeMaker5 = cafeComponent3.coffeeMaker()
        val coffeeMaker6 = cafeComponent3.coffeeMaker()
        println("Maker scope / same component coffeeMaker is equal? ${coffeeMaker5 == coffeeMaker6}")
        val coffeeMaker7 = cafeComponent4.coffeeMaker()
        println("Maker scope / different component coffeeMaker is equal? ${coffeeMaker5 == coffeeMaker7}")

        // Non-Scope
        val coffeeBean1 = cafeComponent3.coffeeBean()
        val coffeeBean2 = cafeComponent3.coffeeBean()
        println("Non scope / coffeeBean is equal? ${coffeeBean1 == coffeeBean2}")
    }
}
