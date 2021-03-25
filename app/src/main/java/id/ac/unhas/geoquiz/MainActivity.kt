package id.ac.unhas.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    private val model:QuizViewModel by viewModels()

    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView
    private lateinit var cheatButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)

        //create or get viewmodel object
        Log.d(TAG, "Got a QuizViewModel: $model")
        Log.d(TAG,"Got an Activity: $this")

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)
        cheatButton = findViewById(R.id.cheat_button)


        val questionTextResId = model.currentQuestionText

        questionTextView.setText(questionTextResId)

        trueButton.setOnClickListener { view: View ->
            //Todo response to the click here
            checkAnswer(true)
        }

        nextButton.setOnClickListener {
            model.moveToNext()
            questionTextView.setText(model.currentQuestionText)
        }

        falseButton.setOnClickListener { view: View ->
            //Todo response to the click here
            checkAnswer(false)
        }

        cheatButton.setOnClickListener {
            val intent = Intent(this,CheatActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy called")
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = model.currentQuestionAnswer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }

}