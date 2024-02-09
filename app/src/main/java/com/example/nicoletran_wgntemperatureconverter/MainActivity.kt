package com.example.nicoletran_wgntemperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.text.*

class MainActivity : AppCompatActivity() {

    // initialize
    private lateinit var celsiusSeekBar: SeekBar
    private lateinit var fahrenheitSeekBar: SeekBar
    private lateinit var celsiusOutput: TextView
    private lateinit var fahrenheitOutput: TextView
    private lateinit var message: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set variables to their respective ids
        celsiusSeekBar = findViewById(R.id.celsius_seekbar)
        fahrenheitSeekBar = findViewById(R.id.fahrenheit_seekbar)
        celsiusOutput = findViewById(R.id.celsius_output)
        fahrenheitOutput = findViewById(R.id.fahrenheit_output)
        message = findViewById(R.id.message)

        // set celsius setOnSeekBarChangeListener
        // citation: https://developer.android.com/reference/android/widget/SeekBar.OnSeekBarChangeListener
        // citation: https://www.geeksforgeeks.org/seekbar-in-kotlin/
        celsiusSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, celsiusProgress: Int, fromUser: Boolean) {
                // if user changes celsius Seekbar, change fahrenheit SeekBar
                if (fromUser) {
                    val celsius = celsiusProgress.toDouble()
                    val fahrenheit = celsiusToFahrenheit(celsius) // call celsiusToFahrenheit function
                    fahrenheitSeekBar.progress = fahrenheit.toInt() // update fahrenheit
                    celsiusOutput.text = "%.2f°C".format(celsius)
                    fahrenheitOutput.text = "%.2f°F".format(fahrenheit)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {} // notification that the user has started a touch gesture
            override fun onStopTrackingTouch(seekBar: SeekBar) {} // notification that the user has finished a touch gesture
        })

        // set fahrenheit setOnSeekBarChangeListener
        // citation: https://developer.android.com/reference/android/widget/SeekBar.OnSeekBarChangeListener
        // citation: https://www.geeksforgeeks.org/seekbar-in-kotlin/
        fahrenheitSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, fahrenheitProgress: Int, fromUser: Boolean) {
                // if user changes fahrenheit Seekbar, change celsius SeekBar
                if (fromUser) {
                    val fahrenheit = fahrenheitProgress.toDouble()
                    val celsius = fahrenheitToCelsius(fahrenheit) // call fahrenheitToCelsius function
                    celsiusSeekBar.progress = celsius.toInt() // update celsius
                    celsiusOutput.text = "%.2f°C".format(celsius)
                    fahrenheitOutput.text = "%.2f°F".format(fahrenheit)

                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {} // notification that the user has started a touch gesture
            override fun onStopTrackingTouch(seekBar: SeekBar) {} // notification that the user has finished a touch gesture
        })

    }

    // function to convert celsius to fahrenheit
    private fun celsiusToFahrenheit(celsius: Double): Double {
        return ((celsius * 9.0 / 5.0) + 32.0)
    }

    // function to convert fahrenheit to celsius
    private fun fahrenheitToCelsius(fahrenheit: Double): Double {
        return ((fahrenheit - 32.0) * 5.0 / 9.0)
    }
}