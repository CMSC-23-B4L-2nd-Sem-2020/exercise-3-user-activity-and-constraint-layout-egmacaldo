package com.example.lightsout

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var idList : List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // store the created list and the hashmap for the indices of the boxes
        idList = createIdList()

        // add a click listener to the submit button
        findViewById<Button>(R.id.submit_button).setOnClickListener {
            addName(it)
        }
        // add a click listener to the text view for the name
        findViewById<TextView>(R.id.name_text).setOnClickListener {
            updateName(it)
        }

        // set the click listeners for the boxes
        setListeners()
    }

    // function to create a list of the ids of the boxes then returns it
    private fun createIdList() :List<Int>{
        return listOf(
            R.id.box_1,
            R.id.box_2,
            R.id.box_3,
            R.id.box_4,
            R.id.box_5,
            R.id.box_6,
            R.id.box_7,
            R.id.box_8,
            R.id.box_9,
            R.id.box_10,
            R.id.box_11,
            R.id.box_12,
            R.id.box_13,
            R.id.box_14,
            R.id.box_15,
            R.id.box_16,
            R.id.box_17,
            R.id.box_18,
            R.id.box_19,
            R.id.box_20,
            R.id.box_21,
            R.id.box_22,
            R.id.box_23,
            R.id.box_24,
            R.id.box_25
        )
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

    // function that returns the id with the specific index
    private fun getId(int: Int) : Int = idList[int]

    // function to obtain the index position of the box that is clicked
    private fun getIndex(view: View):Int{
        for(index in 0..24){
            if(idList[index]==view.id){
                return index
            }
        }
        return -1
    }

    // function to set the listeners for the boxes
    private fun setListeners() {
        for(index in (0..24)){
            findViewById<TextView>(getId(index)).setOnClickListener {
                changeColor(it)
            }
        }
    }

    // function to change the color of the boxes
    private fun changeColor(view: View) {
        // get position
        val index:Int = getIndex(view)

        val color:Int = (view.background as ColorDrawable).color

        if(color == Color.DKGRAY) view.setBackgroundColor(Color.rgb(255,211,0))
        else view.setBackgroundColor(Color.DKGRAY)

    }
}
