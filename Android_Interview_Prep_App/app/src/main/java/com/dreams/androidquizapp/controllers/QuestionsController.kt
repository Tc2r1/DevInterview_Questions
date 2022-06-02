package com.dreams.androidquizapp.controllers

import android.util.Log
import com.dreams.androidquizapp.models.Question
import com.dreams.androidquizapp.network.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class QuestionsController {

    val job = Job()
    val coroutineScope = CoroutineScope(Dispatchers.IO + job)
    private val TAG = "QCTEST"
    private var questionsList: ArrayList<Question>? = null
    val questions: ArrayList<Question>
        get() {
            questionsList = ArrayList()
//            loadQuestions()
            coroutineScope.launch {
                getQuestions()
            }
            return questionsList as ArrayList<Question>
        }

    private fun loadQuestions() {
        val question1 = Question(
            1,
            "multi",
            "What is Android?",
            "Android is a stack of software for mobile devices which includes an Operating System, middleware and some key applications. The application executes within its own process and its own instance of Dalvik Virtual Machine.",
            "A stack of software for mobile devices.")
        questionsList!!.add(question1)
        val question2 = Question(
            2,
            "multi",
            "What is a Service?",
            "Android is a stack of software for mobile devices which includes an Operating System, middleware and some key applications. The application executes within its own process and its own instance of Dalvik Virtual Machine.A component that runs in the background to perform long term running operations, Services continue while app is destroyed.",
            "It performs background functionalities.")
        questionsList!!.add(question2)
        val question3 = Question(
            3,
            "multi",
            "What is the APK format?",
            "The Android packaging key is compressed with classes,UI's, supportive assets and manifest.All files are compressed to a single file is called APK.",
            "It is compressed with classes,UI's, supportive assets and manifest.")
        questionsList!!.add(question3)
        val question4 = Question(
            4,
            "multi",
            "What is an intent?",
            "It is connected to either the external world of application or internal world of application ,Such as, opening a pdf is an intent and connect to the web browser.etc.",
            "It is a declaration to do something.")
        questionsList!!.add(question4)
        val question5 = Question(
            5,
            "multi",
            "What is an android manifest file?",
            "Every application must have an AndroidManifest.xml file (with precisely that name) in its root directory. The manifest file presents essential information about your app to the Android system, information the system must have before it can run any of the app's code.",
            " It is a resource file which contains all the details needed by the android system about the application.")
        questionsList!!.add(question5)
    }

    suspend fun getQuestions(): ArrayList<Question> {
        var questionsList: ArrayList<Question> = arrayListOf()
        withContext(Dispatchers.IO){
            // Call AnswersApiService to enqueue Retrofit request (starts the call on background thread). Returns call object
            val response = QuestionsApi.retrofitService.getQuestionsJson()
            val array = response.body()
            Log.i(TAG, "onResponse Array: $array")
            for (item in array?.questions!!) {
                val tempId = item.id
                val tempQuestion = item.question
                val tempDetails = item.details
                val tempType = item.questionType
                val tempShortAns = item.shortAns
                val tempTF = item.trueOrFalse
                val temp: Question
                Log.i(TAG, "TempQuestion: $tempQuestion $tempId")

                // Skips boolean type questions. Implement feature later
                if (tempType == "bool") continue

                temp = Question(
                        tempId,
                        tempType,
                        tempQuestion,
                        tempDetails,
                        tempShortAns,
                        tempTF
                        )
                questionsList.add(temp)
            }
        }
        return questionsList
    }
}