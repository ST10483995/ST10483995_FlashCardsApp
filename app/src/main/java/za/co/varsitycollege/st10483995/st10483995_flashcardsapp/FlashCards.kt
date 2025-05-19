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

    val questions = arrayOf(
        "The skin is the largest human organ",
        "O negative is the rarest blood type",
        "Water boils at 50 degrees Celsius",
        "Portuguese is the official language of Mozambique",
        "India is a European country"
    )

    val answers = arrayOf(true, false, false, true, false)

    val useranswer = BooleanArray(5)

    var counter = 0
    var trueFalse = false
    var falseTrue = false
    var score = 0
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
        // Declarations
        val questionView = findViewById<TextView>(R.id.questionView)
        val titleView = findViewById<TextView>(R.id.titleView)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)


        questionView.text = questions[counter]



        trueButton.setOnClickListener {
            trueFalse = true
            falseTrue = false
        }

        falseButton.setOnClickListener {
            falseTrue = true
            trueFalse = true
        }


//        fun check(useranswer: Boolean) {
//            val correctAnswer: Boolean = answers[counter]
//            if (useranswer[counter] == correctAnswer) {
//                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
//            }
//        }

        useranswer[counter] = trueFalse



        nextButton.setOnClickListener {
            counter++
            questionView.text = questions[counter]
            if (counter == 4) {
                val intent = Intent(this, Score::class.java)
                startActivity(intent)
            }
        }


        if (useranswer[counter] == answers[counter]) {
            score++
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }


        if (counter == questions.size - 1) {

            val intent = Intent(this, Score::class.java).apply {
                putExtra("questions", questions)
                putExtra("answers", answers)
                putExtra("useranswer", useranswer)
                putExtra("score", score)

            }
        }
    }

    private operator fun Boolean.get(counter: Int): Any {
        TODO("Not yet implemented")
    }
}
