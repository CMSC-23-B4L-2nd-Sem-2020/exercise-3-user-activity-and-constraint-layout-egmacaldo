package com.example.lightsout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add a click listener to the submit button
        findViewById<Button>(R.id.submit_button).setOnClickListener {
            addName(it)
        }
        // add a click listener to the text view for the name
        findViewById<TextView>(R.id.name_text).setOnClickListener {
            updateName(it)
        }
    }

    // function to set name
    private fun addName(view: View) {
        // reference the edit text and the text view for name
        val editText = findViewById<EditText>(R.id.name_edit)
        val nameTextView = findViewById<TextView>(R.id.name_text)

        // set the text for the text view from the text in edit text
        nameTextView.text = editText.text

        // change the visibility of the input, button and the text view
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nameTextView.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    // function to edit name
    private fun updateName (view: View) {
        // reference the edit text and the submit button
        val editText = findViewById<EditText>(R.id.name_edit)
        val submitButton = findViewById<Button>(R.id.submit_button)


        // change the visibility of the input, button and the text view
        editText.visibility = View.VISIBLE
        submitButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}
