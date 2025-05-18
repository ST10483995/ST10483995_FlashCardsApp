package za.co.varsitycollege.st10483995.st10483995_flashcardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

    val answers = arrayOf(
        "True",
        "False",
        "False",
        "True",
        "False"
    )

    val useranswer = arrayOf(
        "",
        "",
        "",
        "",
        ""
    )
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
        var counter = 0
        questionView.text = questions[0]
       nextButton.setOnClickListener{
           counter ++
           questionView.text = questions[counter]
           trueButton.isEnabled = true
           falseButton.isEnabled = true
           if (counter == 4) {
               val intent = Intent(this, Score::class.java)
               startActivity(intent)
           }


       }

        }
    }
