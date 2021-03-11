package id.ac.unhas.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel


class QuizViewModel : ViewModel() {

    init {
        Log.i("QuizViewModel","QuizViewModel created")
    }

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    private var currentIndex = 0

    override fun onCleared() {
        super.onCleared()
        Log.i("QuizViewModel","QuizViewModel destroyed!")
    }

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext(){
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}