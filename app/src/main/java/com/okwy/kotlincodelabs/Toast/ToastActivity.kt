package com.okwy.kotlincodelabs.Toast

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.okwy.kotlincodelabs.R

class ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)
    }

    fun testToast(view: View?) {
        val toast = Toast.makeText(applicationContext, "Testing Toast", Toast.LENGTH_SHORT)
        val v = toast.view
        //v.setBackgroundColor(Color.BLUE);
        v!!.background.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN)
        val text = v.findViewById<TextView>(android.R.id.message)
        text.setTextColor(Color.WHITE)
        //        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 200);
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    fun testCustomToast(view: View?) {
        Log.i("Custom toast", "Inside method")
        val layout: View = layoutInflater.inflate(
            R.layout.activity_toast_custom,
            findViewById<View>(R.id.toast_custom) as? ViewGroup
        )
        val toaster = Toast(applicationContext)
//        this.duration = Toast.LENGTH_LONG
        with(toaster) {
            duration = Toast.LENGTH_LONG
            setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            setView(layout)
            show()
        }
        Log.i("Custom toast", "Past toast.show()")
    }
}