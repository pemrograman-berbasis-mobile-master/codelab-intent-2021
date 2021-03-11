package id.ac.unhas.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel


class QuizViewModel : ViewModel() {

    init {
        Log.i("QuizViewModel","QuizViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("QuizViewModel","QuizViewModel destroyed!")
    }
}