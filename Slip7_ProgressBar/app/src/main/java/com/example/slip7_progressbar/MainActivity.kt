package com.example.slip7_progressbar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // on below line we are creating a variable.
    lateinit var showProgressBtn: Button
    lateinit var loadingPB: ProgressBar
    var isProgressVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // on below line we are initializing our variables.
        showProgressBtn = findViewById(R.id.idBtnDisplayProgress)
        loadingPB = findViewById(R.id.idPBLoading)

        // on below line we are adding
        // click listener for our button
        showProgressBtn.setOnClickListener {
            // on below line we are checking
            // if progress bar is already visible.
            if (isProgressVisible) {
                // if it is visible we are
                // updating text for our button.
                showProgressBtn.text = "Show Progress Bar"

                // on below line we are changing
                // its visibility
                loadingPB.visibility = View.GONE

                // on below line we are updating
                // is progress visible to false
                isProgressVisible = false
            } else {
                // this condition will be called
                // if progress bar visibility is gone
                isProgressVisible = true

                // on below line we are updating text for our button.
                showProgressBtn.text = "Hide Progress Bar"

                // on below line we are changing
                // visibility for our progress bar.
                loadingPB.visibility = View.VISIBLE
            }
        }
    }
}
