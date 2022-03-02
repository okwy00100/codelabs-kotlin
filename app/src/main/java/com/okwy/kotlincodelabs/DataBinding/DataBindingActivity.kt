package com.okwy.kotlincodelabs.DataBinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.okwy.kotlincodelabs.R
import com.okwy.kotlincodelabs.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {
    lateinit var binding : ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_data_binding)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

        binding.doneButton.setOnClickListener { addNickname(it) }
        binding.nicknameText.setOnClickListener { updateNickname(it) }
    }


    private fun updateNickname(view: View) {
//        val editText = findViewById<EditText>(R.id.editText)
//        val doneButton: Button = findViewById(R.id.done_button)

        binding.editText.visibility = View.VISIBLE
        view.visibility = View.GONE
        binding.doneButton.visibility = View.VISIBLE

        binding.editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.editText, 0)

        binding.doneButton.setOnClickListener { addNickname(it) }


    }

    private fun addNickname(view: View) {

//        val editText = findViewById<EditText>(R.id.editText)
//        val nicknameText = findViewById<TextView>(R.id.nickname_text)

        binding.nicknameText.text = binding.editText.text
        binding.editText.visibility = View.GONE
        view.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}