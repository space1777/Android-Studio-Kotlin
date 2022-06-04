package com.example.bmicalculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)


        val bmi = weight / (height / 100.0).pow(2.0)

        val heightTextView = findViewById<TextView>(R.id.heightTextView)
        val weightTextView = findViewById<TextView>(R.id.weightTextView)
        val bmiTextView = findViewById<TextView>(R.id.bmiTextView)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        heightTextView.setText("신장 : ${height}")
        weightTextView.setText("체중 : ${weight}")
        bmiTextView.setText("BMI : ${bmi}")

        val result = when {
            bmi >= 25 -> "비만"
            bmi >= 23 -> "과체중"
            bmi >= 18.5 -> "정상"
            else -> "저체중"
        }
        resultTextView.setText("${result}")

    }
}