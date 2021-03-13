package com.airat.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.airat.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val username: String = intent.getStringExtra(Constants.USER_NAME).toString()
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0).toString()
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0).toString()

        binding.tvName.text = username
        binding.tvScore.text = "Your score is $correctAnswers out of  $totalQuestions"

        binding.btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}