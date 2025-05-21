package za.co.varsitycollege.st10483995.st10483995_flashcardsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.lang.UProperty.NameChoice
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

data class QuestionsLists(
    val question: String,
    var answer: Boolean,
    var useranswer: Boolean? = null
)

var currentIndex = 0
var scoreCounter = 0
class FlashCards : AppCompatActivity() {

    //Declaration of the arrays
    private val questions = mutableListOf(
        QuestionsLists("Queen Elizabeth owned 2000 pairs of gloves", true),
        QuestionsLists("Ancient Egyptians invented toothpaste 300 years ago",false),
        QuestionsLists("Ketchup was originally sold as detergent", false),
        QuestionsLists("Cleopatra married two of her brothers",true),
        QuestionsLists("Switzerland has the world's oldest parliament", false)
    )






    @SuppressLint("MissingInflatedId")
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
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val doneButton = findViewById<Button>(R.id.doneButton)
        doneButton.visibility = View.GONE


        //To show the questions of the screen
        questionView.text = questions[currentIndex].question

        //Initialising the true button
        trueButton.setOnClickListener {
            falseButton.isEnabled = false

            questions[currentIndex].answer = true
            checkAnswer(true)
        }

        //Initialising the false button
        falseButton.setOnClickListener {
            trueButton.isEnabled = false

            questions[currentIndex].answer = false
            checkAnswer(false)
        }

        doneButton.setOnClickListener{
            val intent = Intent(this, Score::class.java)
            startActivity(intent)
        }


        //Corresponding the user answer to a value
        questions[currentIndex].answer = true


        //Initialising the next button
        nextButton.setOnClickListener {
            currentIndex++

            //Set the questions to change in the TextView
            questionView.text = questions[currentIndex].question

            trueButton.isEnabled = true
            falseButton.isEnabled = true

            //Argument to loop through the questions
            if (currentIndex == 4) {
                nextButton.visibility = View.GONE
                doneButton.visibility = View.VISIBLE
            }
        }



//        if (counter == questions.size - 1) {
//            val intent = Intent(this, Score::class.java).apply {
//                putExtra("questions", questions)
//                putExtra("answer", answer)
//                putExtra("useranswer", useranswer)
//                putExtra("score", score)
//                putExtra()
//
//                Starting the intent
//                startActivity(intent)
//                finish()
//            }
//        }


    }
    private fun checkAnswer(userChoice: Boolean){
        val questionNow = questions[currentIndex]
        questionNow.useranswer = userChoice

        val correct = questionNow.useranswer == questionNow.answer

        Toast.makeText(
            this,
            if (correct) "Correct!"
            else "Incorrect",
            Toast.LENGTH_SHORT
        ).show()

        if (correct){
            scoreCounter++
        }
    }


}



