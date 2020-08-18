package com.example.exercise_ui_thread

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    lateinit var coroutineScope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.max = 100
        // biasa buat fetching atau untuk read-write data
        // Dispatchers yang memberangkatkan
        coroutineScope = CoroutineScope(Dispatchers.IO)
//        progressDialog = ProgressDialog(this)
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
    }

    fun startProgress(view: View) {
//        val progressBarTask = ProgressBarTask(progressBar)
//        progressBarTask.execute()
//        progressBar.progress = 40
//        val  progressDialog = ProgressDialogTask(progressDialog)
//        progressDialog.execute()
//        println("start")
//        GlobalScope.launch {
//            for (i in 1..100) {
//                println(i)
//                progressBar.setProgress(i)
//                delay(200)
//            }
//        }
//        println("stop")

//        coroutineScope.launch {
//            for (i in 1..100) {
//                progressBar.progress = i
//                delay(200)
//                println(i)
//            }
//        }
        val fetchDataTask = FetchDataTask()
        fetchDataTask.execute()
    }
}

