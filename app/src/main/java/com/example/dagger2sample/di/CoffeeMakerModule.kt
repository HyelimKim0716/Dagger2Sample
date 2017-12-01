package com.example.dagger2sample.di

import com.example.dagger2sample.data.Heater
import com.example.dagger2sample.data.HeaterA
import com.example.dagger2sample.data.Pump
import com.example.dagger2sample.data.PumpA
import dagger.Module
import dagger.Provides

/**
 * Created by Owner on 2017-11-29.
 *
 * @Module
 * @Provides
 * Those will affect creating real DI codes in @Component class
 */
@Module
class CoffeeMakerModule{

    @Provides fun provideHeater(): Heater = HeaterA()

    @Provides fun providePump(heater: Heater): Pump = PumpA(heater)

}