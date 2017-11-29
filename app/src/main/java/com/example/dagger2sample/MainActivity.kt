package com.example.dagger2sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
//        val coffeeMaker1 = CoffeeMaker(heater, pump)
//        coffeeMaker1.brew()

        /*
        * DI let user to get coffee without CoffeeMaker dependency (which heater or pump instance)
        * Injection class is DI setting file.
        * Let's make a cup of coffee.
        * You can get heater and pump from Injection class, so you don't need to know which heater has to be used.
        * */
//        val coffeeMaker2 = CoffeeMaker(Injection.provideHeater(), Injection.providePump())
//        coffeeMaker2.brew()
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
//        DaggerCoffeeComponent.create().make().brew()

        val coffeeMaker3 = CoffeeMaker()
        DaggerCoffeeComponent.create().inject(coffeeMaker3)
        coffeeMaker3.brew()



    }
}
