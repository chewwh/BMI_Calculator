package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCal.setOnClickListener(){
            calculateBMI()
        }

        buttonReset.setOnClickListener() {
            reset()
        }
    }

    private fun calculateBMI() {
        val weight : Float = editTextWeight.text.toString().toFloat()
        val height : Float = editTextHeight.text.toString().toFloat()
        val bmi = weight / height.pow(n = 2)

        

        if (bmi < 18.5) {
            imageViewPicture.setBackgroundResource(R.drawable.under)
            txtStatus.text = String.format("%s %s", "Status :" , getString(R.string.under))
        }
        else if (bmi >= 18.5 && bmi <= 24.9) {
            imageViewPicture.setBackgroundResource(R.drawable.normal)
            txtStatus.text = String.format("%s %s", "Status :" , getString(R.string.normal))
        }
        else {
            imageViewPicture.setBackgroundResource(R.drawable.over)
            txtStatus.text = String.format("%s %s", "Status :" , getString(R.string.over))
        }

        txtBMI.text = String.format("%s %.2f", "BMI :" ,bmi)
    }

    private fun reset() {
        editTextWeight.text.clear()
        editTextHeight.text.clear()
    }

}

