package com.okwy.kotlincodelabs.SnackBar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.okwy.kotlincodelabs.R

class SnackbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)
    }

    fun testSnackbar(view: View?) {
        // Snackbar.make(view, "Hello there", Snackbar.LENGTH_LONG).show();
        val snackBar = Snackbar.make(view!!, "Hello there", Snackbar.LENGTH_LONG)
        snackBar.setActionTextColor(Color.BLUE)
        val snackBarView = snackBar.view
        //        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
//        textView.setTextColor(Color.RED);
        snackBar.show()
    }
}