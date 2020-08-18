package com.example.exercise_ui_thread

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.AsyncTask
import android.widget.ProgressBar
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection

// loading diatas background
class ProgressDialogTask(var progressDialog: ProgressDialog) : AsyncTask<String, Int, Unit>() {
    override fun onPreExecute() {
        progressDialog.show()
    }

    override fun onPostExecute(result: Unit?) {
        progressDialog.dismiss()
    }

    override fun doInBackground(vararg params: String?) {
        for (i in 1..100) {
            Thread.sleep(200)
            println(i)
        }
    }
}

// AsyncTask<Unit, Unit, Unit>
// Unit pertama untuk parameter di dalam doInBackground
// Unit ke 2 dipake sama onProgressUpdate
// Unit ke 3 untuk return pada doInBackground
class ProgressBarTask(var progressBar: ProgressBar) : AsyncTask<Unit, Unit, Unit>() {
    // vararg atau var argument sama dengan array
    // kalau di java pake ...
    override fun doInBackground(vararg args: Unit?) {
        for (i in 1..100) {
            progressBar.progress = i
            Thread.sleep(200)
        }
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

class FetchDataTask: AsyncTask<String, Unit, Unit>() {

    // kalau aksesnya lewat thread utama ngga bakal bisa
    override fun doInBackground(vararg params: String?) {
//        val url = URL("https://jsonplaceholder.typicode.com/users")
        val url = URL("http://10.0.2.2:5000/rooms")
        val  urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.requestMethod = "GET"
        // val response = url.readText()
        val response = urlConnection.inputStream.bufferedReader().readText()
        println(response)

        // ambil data per key
//        val jsonObject = JSONObject(response)
//        println(jsonObject.get("name"))

        // ambil data yang berbentuk array
//        val jsonArray = JSONArray(response)
//        println(jsonArray[0])
//        println(jsonArray[1])

        val jsonObject = JSONObject(response)
        println(jsonObject.getJSONArray("data").getJSONObject(0).get("roomNumb"))
    }
}
