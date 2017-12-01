package com.example.dagger2sample.data

import javax.inject.Inject

/**
 * Created by Owner on 2017-12-01.
 */
class CafeInfo(val name: String = "Hayley's Cafe") {

    fun welcome() { println("Welcome $name") }


}