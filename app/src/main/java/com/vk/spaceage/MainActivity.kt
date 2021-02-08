package com.vk.spaceage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    val viewModel: SpaceAgeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSpinnerChoiceListener()
        viewModel.convertedAge.observe(this){
            val textView = findViewById<TextView>(R.id.convertedAgeTextView)
            textView.text = it.toString()
        }
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

                    }¸
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }
                }
    }


}
