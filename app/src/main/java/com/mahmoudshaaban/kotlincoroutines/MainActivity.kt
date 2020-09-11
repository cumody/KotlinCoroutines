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
        Log.d(TAG, "Before RunBlocking")
        // RunBlocking is executed in main Thread
        runBlocking {
            Log.d(TAG, "Start RunBlocking")

            // we can put launch without GlobalScope b/c we are already in mainThread(RunBlocking)
            launch(IO) {

                delay(5000L)
                Log.d(TAG, "Finished IO Coroutine 1")

            }
            launch(IO) {

                delay(5000L)
                Log.d(TAG, "Finished IO Coroutine 2")

            }


            Log.d(TAG, "End RunBlocking")

        }
        Log.d(TAG, "After RunBlocking")


    }


}