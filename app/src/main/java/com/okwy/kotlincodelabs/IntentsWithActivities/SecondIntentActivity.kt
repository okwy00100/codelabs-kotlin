package com.okwy.kotlincodelabs.IntentsWithActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.okwy.kotlincodelabs.IntentsWithActivities.IntentActivity.Companion.EXTRA_STRING
import com.okwy.kotlincodelabs.R

class SecondIntentActivity : AppCompatActivity() {
    companion object{
        val EXTRA_REPLY = "com.okwy.practiceproject.intentswithactivities.secondintentactivity.extra.REPLY"
    }


    private var replyTextEdit: TextView? = null
    private var textViewExtra: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_intent)

        replyTextEdit = findViewById(R.id.replyEditText)

        textViewExtra = findViewById(R.id.textViewExtra)
        textViewExtra?.text = intent.getStringExtra(EXTRA_STRING)





    }

    fun returnReply(view: android.view.View) {
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, replyTextEdit?.text.toString())
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}