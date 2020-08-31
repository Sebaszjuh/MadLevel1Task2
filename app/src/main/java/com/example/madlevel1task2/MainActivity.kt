package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var score = 0
    private var maxScore = 4
    private var resultRow1 = "F"
    private var resultRow2 = "F"
    private var resultRow3 = "F"
    private var resultRow4 = "F"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        conjunction()
        binding.btnSubmit.setOnClickListener{checkResult()}

    }

    private fun checkResult(){
        if(binding.resultInputRow1.text.toString().toUpperCase() == resultRow1){
            score++
        }
        if(binding.resultInputRow2.text.toString().toUpperCase() == resultRow2){
            score++
        }
        if(binding.resultInputRow3.text.toString().toUpperCase() == resultRow3){
            score++
        }
        if(binding.resultInputRow4.text.toString().toUpperCase() == resultRow4){
            score++
        }

        returnScore()
    }

    private fun conjunction(){
        if(binding.row1Pos1.text.toString() == binding.row1Pos2.text.toString()){
            resultRow1 = "T"
        }
        if(binding.row2Pos1.text.toString() == binding.row2Pos2.text.toString()){
            resultRow2 = "T"
        }
        if(binding.row3Pos1.text.toString() == binding.row3Pos2.text.toString()){
            resultRow3 = "T"
        }
        if(binding.row4Pos1.text.toString() == binding.row4Pos2.text.toString()){
            resultRow4 = "T"
        }
    }

    private fun returnScore(){
        Toast.makeText(this, getString(R.string.score, score, maxScore), Toast.LENGTH_LONG).show()
        reset()
    }

    private fun reset(){
        score = 0
    }
}