package za.co.varsitycollege.st10483995.st10483995_flashcardsapp

import android.os.Bundle
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
        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 5)

        scoreView.text = "You scored $score/$total"
                if (score >= 3) {
                    "Great Job!"
                } else {
                    if (score < 3) {
                        "Keep Practicing"
                    }
                }

    }
}