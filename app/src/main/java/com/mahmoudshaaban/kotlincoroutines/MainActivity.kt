package com.mahmoudshaaban.kotlincoroutines

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val job = GlobalScope.launch(Dispatchers.Default) {
            repeat(5) {
                Log.d(TAG, "Coroutine 1")
                delay(5000L)
            }


        }

        runBlocking {

            // now what are we doing we freeze the ui until job is completed
            job.join()
            Log.d(TAG, "Main Thread is Continuing")
        }


    }
}