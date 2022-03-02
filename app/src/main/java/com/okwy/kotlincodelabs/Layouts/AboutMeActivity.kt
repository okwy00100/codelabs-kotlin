package com.okwy.kotlincodelabs.Layouts

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.okwy.kotlincodelabs.R

class AboutMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        val doneButton: Button = findViewById(R.id.done_button)
        doneButton.setOnClickListener{addNickname(it)}


        findViewById<TextView>(R.id.nickname_text).setOnClickListener { updateNickname(it) }
    }

    private fun updateNickname(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val doneButton: Button = findViewById(R.id.done_button)

        editText.visibility = VISIBLE
        view.visibility = GONE
        doneButton.visibility = VISIBLE

        editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

        doneButton.setOnClickListener { addNickname(it) }


    }

    private fun addNickname(view: View) {

        val editText = findViewById<EditText>(R.id.editText)
        val nicknameText = findViewById<TextView>(R.id.nickname_text)

        nicknameText.text = editText.text
        editText.visibility = GONE
        view.visibility = GONE
        nicknameText.visibility = VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }


}