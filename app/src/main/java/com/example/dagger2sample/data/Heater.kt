package com.example.dagger2sample.data

/**
 * Created by Owner on 2017-11-29.
 */
interface Heater {
    fun on()
    fun off()
    fun isHot(): Boolean
}