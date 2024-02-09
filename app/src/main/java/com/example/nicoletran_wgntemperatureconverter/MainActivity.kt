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
    }
}