package za.co.varsitycollege.st10483995.st10483995_flashcardsapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val scoreView = findViewById<TextView>(R.id.scoreView)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val reviewView = findViewById<TextView>(R.id.reviewView)
        val total = intent.getIntExtra("total", 5)
        var reviewDisplay: String
        val scoreCounter = intent.getIntExtra("scoreCounter", 0)



        scoreView.text = "You scored $scoreCounter/$total"
                if (scoreCounter >= 3) {
                    "Great Job!"
                } else {
                    if (scoreCounter < 3) {
                        "Keep Practicing"
                    }
                }
//
//        reviewButton.setOnClickListener{
//            reviewDisplay = "Question 1 = True\n"
//            "Question 2 = False\n"
//            "Question 3 = False\n"
//            "Question 4 = True\n"
//            "Question 5 = False"
//        }
//        reviewView.text = reviewDisplay
    }
}