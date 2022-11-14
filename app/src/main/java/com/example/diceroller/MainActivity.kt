package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Roll dice when the app starts
        rollDice();

        //Roll dice when button is clicked
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice();
        }
    }

    //Create new 6 sided Dice objects and roll them
    private fun rollDice() {
        val diceOne = Dice(6);
        val diceTwo = Dice(6);
        val diceOneRoll = diceOne.roll();
        val diceTwoRoll = diceTwo.roll();

        //Find the imageView in the layout
        val diceOneImage: ImageView = findViewById(R.id.imageView);

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceOneRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceOneImage.setImageResource(drawableResource)

        //Repeat steps for second Dice
        val diceTwoImage: ImageView = findViewById(R.id.imageView2);
        val drawableResource2 = when (diceTwoRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceTwoImage.setImageResource(drawableResource2)
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random();
    }
}