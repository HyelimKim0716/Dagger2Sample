package com.example.dagger2sample.data

/**
 * Created by Owner on 2017-11-29.
 */
class PumpA(val heater: Heater) : Pump {
    override fun pump() {
        if (heater.isHot())
            println("PumpA => => pumping => =>")
    }
}