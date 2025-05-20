package za.co.varsitycollege.st10483995.st10483995_flashcardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashCards : AppCompatActivity() {

    //Declaration of the arrays
    val questions = arrayOf(
        "Queen Elizabeth owned 2000 pairs of gloves",
        "Ancient Egyptians invented toothpaste 300 years ago",
        "Ketchup was originally sold as detergent",
        "Cleopatra married two of her brothers",
        "Switzerland has the world's oldest parliament"
    )

    val answers = arrayOf(true, false, false, true, false)

    val useranswer = BooleanArray(5)

    //Declarations for the variables
    var counter = 0
    var trueFalse = false
    var falseTrue = false
    var scoreCounter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flash_cards)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Declarations of ID's
        val questionView = findViewById<TextView>(R.id.questionView)
        val titleView = findViewById<TextView>(R.id.titleView)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)


        //To show the questions of the screen
        questionView.text = questions[counter]

        //Initialising the true button
        trueButton.setOnClickListener {
            trueFalse = true
            falseTrue = false
        }

        //Initialising the false button
        falseButton.setOnClickListener {
            falseTrue = true
            trueFalse = true
        }


        //Corresponding the user answer to a value
        useranswer[counter] = trueFalse


        //Initialising the next button
        nextButton.setOnClickListener {
            counter++

            //Set the questions to change in the TextView
            questionView.text = questions[counter]

            //Argument to loop through the questions
            if (counter == 4) {
                val intent = Intent(this, Score::class.java)
                startActivity(intent)
        }

        //Argument to check across the arrays
        if (useranswer[counter] == answers[counter]) {
            scoreCounter++

            //Making sure a text is shown for whether the answer is correct or not
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }
        }

        //Assigning the counter to a value
        val score = scoreCounter



        if (counter == questions.size - 1) {
            val intent = Intent(this, Score::class.java).apply {
                putExtra("questions", questions)
                putExtra("answers", answers)
                putExtra("useranswer", useranswer)
                putExtra("score", score)

                //Starting the intent
                startActivity(intent)
            }
        }

        }
    }


