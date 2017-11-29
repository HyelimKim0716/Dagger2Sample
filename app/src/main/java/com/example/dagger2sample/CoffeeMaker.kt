package com.example.dagger2sample

import javax.inject.Inject

/**
 * Created by Owner on 2017-11-29.
 */
//class CoffeeMaker @Inject constructor(val heater: Heater, val pump: Pump) {
//
//    fun brew() {
//        heater.on()
//        pump.pump()
//        println(" [_]P coffee! [_]P ")
//        heater.off()
//    }
//
//}

class CoffeeMaker {

    @Inject public var heater: Heater ?= null
    @Inject public var pump: Pump ?= null

    fun brew() {
        heater?.on()
        pump?.pump()
        println(" [_]P coffee! [_]P ")
        heater?.off()
    }

}