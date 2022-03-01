package com.okwy.kotlincodelabs.DiceRoller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.okwy.kotlincodelabs.R

class DiceRollerActivity : AppCompatActivity() {
    private lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        val rollButton : Button = findViewById(R.id.rollButton)
        diceImage = findViewById(R.id.dice_image)

        rollButton.setOnClickListener{ rollDice() }
    }

    private fun rollDice() {
//        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        val resultText : TextView = findViewById(R.id.result_text)
        val randomInt = (1..6).random()
        resultText.text = "Dice Rolled: ${randomInt.toString()}"

        val imageResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }

        diceImage.setImageResource(imageResource)
    }
}