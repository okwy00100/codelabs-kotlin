package com.okwy.kotlincodelabs.DataBinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.okwy.kotlincodelabs.R
import com.okwy.kotlincodelabs.databinding.ActivityDataBindingBinding
import com.okwy.kotlincodelabs.models.MyName

class DataBindingActivity : AppCompatActivity() {
    lateinit var binding: ActivityDataBindingBinding
    private val myName = MyName("Okwy Nwachukwu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_data_binding)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

        binding.myName = myName

        binding.apply {
            doneButton.setOnClickListener { addNickname(it) }
            nicknameText.setOnClickListener { updateNickname(it) }
        }

    }


    private fun updateNickname(view: View) {
//        val editText = findViewById<EditText>(R.id.editText)
//        val doneButton: Button = findViewById(R.id.done_button)

        view.visibility = View.GONE

        binding.apply {
            editText.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            editText.requestFocus()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.editText, 0)

        binding.doneButton.setOnClickListener { addNickname(it) }


    }

    private fun addNickname(view: View) {

//        val editText = findViewById<EditText>(R.id.editText)
//        val nicknameText = findViewById<TextView>(R.id.nickname_text)

        view.visibility = View.GONE

        binding.apply {
            myName?.nickname = nicknameText.text.toString()
            invalidateAll()
            nicknameText.text = editText.text
            editText.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}