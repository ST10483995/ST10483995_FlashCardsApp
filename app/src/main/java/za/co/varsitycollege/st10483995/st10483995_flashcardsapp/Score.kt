package za.co.varsitycollege.st10483995.st10483995_flashcardsapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Declarations
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val reviewView = findViewById<TextView>(R.id.reviewView)
        val closeButton = findViewById<Button>(R.id.closeButton)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val total = 5
        val score = scoreCounter


        //Declaring an setting a text view
        val scoreView = findViewById<TextView>(R.id.scoreView)
        scoreView.text = "You scored $score/$total"


        //Setting the button to show the question reviews
        reviewButton.setOnClickListener{
            reviewView.text = "Question 1 = True\n" + "Question 2 = False\n" + "Question 3 = False\n" + "Question 4 = True\n" + "Question 5 = False"


        }

        closeButton.setOnClickListener {
            finishAffinity()
        }

        val feedback = when {
            score >= 3 -> "Great Job!"
            else -> "Keep Practicing"
        }

        feedbackText.text = feedback
    }
}



