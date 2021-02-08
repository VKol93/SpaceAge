package com.vk.spaceage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    var planet: Planets = Planets.MERCURY
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSpinnerChoiceListener()
        setButtonClickListener()
    }

    enum class Planets(val orbitalPeriod: Double) {
        MERCURY(0.2408467),
        VENUS(0.61519726),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132)
    }

    private fun setButtonClickListener() {

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener {
            val ageEditText = findViewById<EditText>(R.id.ageEditText)
            val age = ageEditText.text.toString().toInt()
            val ageConvert = when (planet) {
                Planets.MERCURY -> yearsConv(age, Planets.MERCURY)
                Planets.VENUS -> yearsConv(age, Planets.VENUS)
                Planets.MARS -> yearsConv(age, Planets.MARS)
                Planets.JUPITER -> yearsConv(age, Planets.JUPITER)
                Planets.SATURN -> yearsConv(age, Planets.SATURN)
                Planets.URANUS -> yearsConv(age, Planets.URANUS)
                Planets.NEPTUNE -> yearsConv(age, Planets.NEPTUNE)
            }
            Toast.makeText(applicationContext, "$ageConvert", Toast.LENGTH_LONG).show()
        }
    }

    private fun yearsConv(age: Int, planet: Planets): Long {
        val planetConvertion = age * planet.orbitalPeriod
        return planetConvertion.roundToLong()
    }

    private fun setSpinnerChoiceListener () {

        val spinner = findViewById<Spinner>(R.id.planetSpinner)
        spinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        when (position) {
                            0 -> {
                                planet = Planets.MERCURY
                            }
                            1 -> {
                                planet = Planets.VENUS
                            }
                            2 -> {
                                planet = Planets.MARS
                            }
                            3 -> {
                                planet = Planets.JUPITER
                            }
                            4 -> {
                                planet = Planets.SATURN
                            }
                            5 -> {
                                planet = Planets.URANUS
                            }
                            6 -> {
                                planet = Planets.NEPTUNE
                            }
                        }

                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }
                }
    }


}
