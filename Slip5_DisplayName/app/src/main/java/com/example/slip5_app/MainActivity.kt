package com.example.slip5_app

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var messageLabel: TextView
    private lateinit var boldRadio: RadioButton
    private lateinit var italicRadio: RadioButton
    private lateinit var underlineCheck: CheckBox
    private lateinit var displayButton: Button
    private lateinit var clearButton: Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        nameInput = findViewById(R.id.name_input)
        messageLabel = findViewById(R.id.message_label)
        boldRadio = findViewById(R.id.bold_radio)
        italicRadio = findViewById(R.id.italic_radio)
        underlineCheck = findViewById(R.id.underline_check)
        displayButton = findViewById(R.id.display_button)
        clearButton = findViewById(R.id.clear_button)

        // Set onClick listeners
        displayButton.setOnClickListener {
            displayMessage()
        }

        clearButton.setOnClickListener {
            clearInputs()
        }


    }

    private fun displayMessage() {
        val name = nameInput.text.toString().trim()
        var labelText = ""

        if (name.isNotEmpty()) {
            labelText = name

            // Apply formatting based on radio button selection
            if (boldRadio.isChecked) {
                labelText = "<b>$labelText</b>"
            }

            if (italicRadio.isChecked) {
                labelText = "<i>$labelText</i>"
            }

            // Apply underline formatting based on checkbox state
            if (underlineCheck.isChecked) {
                labelText = "<u>$labelText</u>"
            }

            // Display the formatted text
            messageLabel.text = android.text.Html.fromHtml(labelText)

            // Set label text color
            messageLabel.setTextColor(Color.BLACK)
        } else {
            messageLabel.text = "Please enter your name."
        }
    }

    private fun clearInputs() {
        nameInput.setText("")
        messageLabel.text = ""
        boldRadio.isChecked = false
        italicRadio.isChecked = false
        underlineCheck.isChecked = false
    }
}

