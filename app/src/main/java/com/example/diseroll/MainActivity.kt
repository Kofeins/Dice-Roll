package com.example.diseroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btnRoll)
        rollButton.setOnClickListener{
           animRoll()
        }
    }

    private fun animRoll() {

        val handler = android.os.Handler()
        val end: Int = (4..7).random()
        for (i in 0..end step 1){
            handler.postDelayed({rollDices()}, i * 300L)
        }
    }

    private fun rollDices() {
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val showDice1: ImageView = findViewById(R.id.imageView1)
        val showDice2: ImageView = findViewById(R.id.imageView2)
        val num1: Int = dice1.roll()
        val num2: Int = dice2.roll()

        when(num1){
            1 -> showDice1.setImageResource(R.drawable.dice1)
            2 -> showDice1.setImageResource(R.drawable.dice2)
            3 -> showDice1.setImageResource(R.drawable.dice3)
            4 -> showDice1.setImageResource(R.drawable.dice4)
            5 -> showDice1.setImageResource(R.drawable.dice5)
            6 -> showDice1.setImageResource(R.drawable.dice6)
        }

        when(num2){
            1 -> showDice2.setImageResource(R.drawable.dice1)
            2 -> showDice2.setImageResource(R.drawable.dice2)
            3 -> showDice2.setImageResource(R.drawable.dice3)
            4 -> showDice2.setImageResource(R.drawable.dice4)
            5 -> showDice2.setImageResource(R.drawable.dice5)
            6 -> showDice2.setImageResource(R.drawable.dice6)
        }


    }

    class Dice(val numSides: Int){
            fun roll(): Int{
                return (1..numSides).random()
            }

    }
}