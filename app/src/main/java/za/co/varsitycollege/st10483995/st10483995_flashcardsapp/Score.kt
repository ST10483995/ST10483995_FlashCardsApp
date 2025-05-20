package za.co.varsitycollege.st10483995.st10483995_flashcardsapp

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
        val total = intent.getIntExtra("total", 5)


//        val questions = intent.getSerializableExtra("questions") as ArrayList<String>
//        val answers = intent.getSerializableExtra("answers") as ArrayList<String>
//        val useranswer = intent.getSerializableExtra("useranswer") as ArrayList<String>
        val score = intent.getIntExtra("score", 0)

        //Declaring an setting a text view
        val scoreView = findViewById<TextView>(R.id.scoreView)
        scoreView.text = "You scored $score/$total"
//        val scoreBuilder = StringBuilder()
//        scoreView.text = scoreBuilder.toString()

        //Setting the button to show the question reviews
        reviewButton.setOnClickListener{
//            reviewDisplay = "Question 1 = True\n"
//            "Question 2 = False\n"
//            "Question 3 = False\n"
//            "Question 4 = True\n"
//            "Question 5 = False"
        }
    }
}



