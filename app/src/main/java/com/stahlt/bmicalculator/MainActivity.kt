package com.stahlt.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var etWeight: EditText
    private lateinit var etHeight: EditText
    private lateinit var tvResult: TextView
    private lateinit var btCalculate: Button
    private lateinit var btClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        tvResult = findViewById(R.id.tvResult)
        btCalculate = findViewById(R.id.btCalculate)
        btClear = findViewById(R.id.btClear)

        btCalculate.setOnClickListener {
            btCalculateOnClick()
        }

        btClear.setOnClickListener {
            btClearOnClick()
        }

        btClear.setOnLongClickListener {
            btClearOnLongClick()
            false
        }
    }

    private fun btClearOnLongClick() {
        Toast.makeText(this, "Clear button", Toast.LENGTH_SHORT).show()
    }

    private fun btClearOnClick() {
        etWeight.setText("")
        etHeight.setText("")
        etWeight.error = null
        etHeight.error = null
        tvResult.text = "0.0"
        etWeight.requestFocus()
    }

    private fun btCalculateOnClick() {
        if (etWeight.text.isEmpty()) {
            etWeight.error = "Need to be filled"
            return
        } else if (etHeight.text.isEmpty()) {
            etHeight.error = "Need to be filled"
            return
        }
        val height = etHeight.text.toString().toDouble()
        val weight = etWeight.text.toString().toDouble()

        val bmi = weight / height.pow(2.0)

        tvResult.text = "%.1f".format(bmi)
    }
}