package com.example.slip3_phonenumbercheck

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var phoneNumberEditText: EditText
    private lateinit var checkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        checkButton = findViewById(R.id.checkButton)

        checkButton.setOnClickListener {
            val phoneNumber = phoneNumberEditText.text.toString().trim()

            if (phoneNumber.isEmpty()) {
                showToast("Please enter a phone number!")
            } else if (isValidPhoneNumber(phoneNumber)) {
                showToast("Phone number is valid!")
            } else {
                showToast("Invalid phone number! Phone number should start with 040, 041, 050, 0400, or 044 and have 6-8 digits.")
            }
        }
    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        // Regular expression to validate phone number format
        val regex = Regex("(040|041|050|0400|044)\\d{6,8}")
        return phoneNumber.matches(regex)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
