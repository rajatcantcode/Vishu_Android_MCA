package com.example.slip2_perfectnumberornot

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
                if (isPerfectNumber(number)) {
                    showToast("The number is a perfect number!")
                } else {
                    showToast("The number is not a perfect number!")
                }
            } else {
                showToast("Please enter a number!")
            }
        }
    }

    private fun isPerfectNumber(number: Int): Boolean {
        var sum = 0
        for (i in 1 until number) {
            if (number % i == 0) {
                sum += i
            }
        }
        return sum == number
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
