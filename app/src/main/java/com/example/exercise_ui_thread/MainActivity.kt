package com.example.exercise_ui_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.max = 100
    }

    fun startProgress(view: View) {
        val progressThread = ProgressThread(progressBar)
        progressThread.start()
//        progressBar.progress = 40
    }
}

class ProgressThread(var progressBar: ProgressBar): Thread() {
    override fun run() {
        for (i in 1..100) {
            progressBar.progress = i
            println(i)
            Thread.sleep(200)
        }
    }
}