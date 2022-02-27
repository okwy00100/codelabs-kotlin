package com.okwy.kotlincodelabs.IntentsWithActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.TextView
import com.okwy.kotlincodelabs.Main.MainActivity
import com.okwy.kotlincodelabs.R

class IntentActivity : AppCompatActivity() {

    companion object {
        val EXTRA_STRING = "com.okwy.kotlincodelabs.intentwithactivities.intentActivity"
        val TEXT_REQUEST = 1
    }

    private val LOG_TAG = MainActivity::class.java.simpleName

    private var editTextMain: EditText? = null
    private var replyReceived: TextView? = null
    private var replyMessage: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        editTextMain = findViewById(R.id.editTextMain)
        replyReceived = findViewById(R.id.textView6)
        replyMessage = findViewById(R.id.textViewReply)
    }

    fun launchSecondActivity(view: android.view.View) {
        Log.d(LOG_TAG, "Button Clicked")
        println(">>>getName>>>" + MainActivity::class.java.name)
        println(">>>getSimpleName>>>" + MainActivity::class.java.simpleName)
        println(">>>getCanonicalName>>>" + MainActivity::class.java.canonicalName)

        val intent = Intent(this, SecondIntentActivity::class.java)
        intent.putExtra(EXTRA_STRING, editTextMain?.text.toString())
        startActivityForResult(intent, TEXT_REQUEST)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                replyMessage?.visibility = VISIBLE
                replyReceived?.visibility = VISIBLE
                replyMessage?.text = data!!.getStringExtra(SecondIntentActivity.EXTRA_REPLY)
            }
        }

    }
}