package com.example.dagger2sample.data

import javax.inject.Inject

/**
 * Created by Owner on 2017-12-01.
 */
class NewCoffeeMaker @Inject constructor(heater: Heater) {

    fun brew(coffeeBean: CoffeeBean) { println("CoffeeBean $coffeeBean [_]P coffee! [_]P ")}
}