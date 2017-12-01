package com.example.dagger2sample.data

/**
 * Created by Owner on 2017-11-29.
 */
class HeaterA: Heater {

    var heating: Boolean = false

    override fun on() {
        println("HeaterA : ~~~ heating ~~~")
        heating = true
    }

    override fun off() {
        heating = false
    }

    override fun isHot(): Boolean = heating
}