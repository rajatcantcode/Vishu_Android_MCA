package com.example.slip3_armstrong

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var checkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        checkButton = findViewById(R.id.checkButton)

        checkButton.setOnClickListener {
            val numberStr = editText.text.toString()
            if (numberStr.isNotEmpty()) {
                val number = numberStr.toInt()
                if (isArmstrong(number)) {
                    showToast("$number is an Armstrong number!")
                } else {
                    showToast("$number is not an Armstrong number!")
                }
            } else {
                showToast("Please enter a number!")
            }
        }
    }

    private fun isArmstrong(number: Int): Boolean {
        val originalNumber = number
        val numDigits = number.toString().length
        var sum = 0
        var temp = number

        while (temp > 0) {
            val digit = temp % 10
            sum += Math.pow(digit.toDouble(), numDigits.toDouble()).toInt()
            temp /= 10
        }

        return sum == originalNumber
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}