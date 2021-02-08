package com.vk.spaceage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToLong

enum class Planets(val orbitalPeriod: Double) {
    MERCURY(0.2408467),
    VENUS(0.61519726),
    MARS(1.8808158),
    JUPITER(11.862615),
    SATURN(29.447498),
    URANUS(84.016846),
    NEPTUNE(164.79132)
}
class SpaceAgeViewModel: ViewModel() {
    var planet: Planets = Planets.MERCURY

    val convertedAge = MutableLiveData<Int>()
    fun yearsConv(age: Int, planet: Planets): Long {
        val planetConvertion = age * planet.orbitalPeriod
        return planetConvertion.roundToLong()
    }


    private fun ageConvert(age: Int) {
        val ageConvert = when (planet) {
            Planets.MERCURY -> yearsConv(age, Planets.MERCURY)
            Planets.VENUS -> yearsConv(age, Planets.VENUS)
            Planets.MARS -> yearsConv(age, Planets.MARS)
            Planets.JUPITER -> yearsConv(age, Planets.JUPITER)
            Planets.SATURN -> yearsConv(age, Planets.SATURN)
            Planets.URANUS -> yearsConv(age, Planets.URANUS)
            Planets.NEPTUNE -> yearsConv(age, Planets.NEPTUNE)
        }
    }
}