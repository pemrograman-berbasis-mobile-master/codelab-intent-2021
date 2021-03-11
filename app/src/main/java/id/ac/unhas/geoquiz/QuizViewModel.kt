package id.ac.unhas.geoquiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


class QuizViewModel(private val state: SavedStateHandle) : ViewModel() {

    companion object{
        private const val CURRENT_INDEX = "currentIndex"
    }

    private var currentIndex: Int

    init {
        Log.d("QuizViewModel","QuizViewModel created")
        currentIndex = state.get<Int>(CURRENT_INDEX)?:0
        Log.d("QuizViewModel","current Index: $currentIndex")
    }

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )


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
        state.set(CURRENT_INDEX,currentIndex)
    }


}