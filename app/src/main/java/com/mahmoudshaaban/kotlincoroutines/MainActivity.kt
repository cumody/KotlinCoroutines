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
        GlobalScope.launch(Dispatchers.IO) {
            // Dispatchers.Unconfined is different: it executes coroutine immediately on the current thread
            // and later resumes it in whatever thread called resume.
            // It is usually a good fit for things like intercepting regular non-suspending API
            // or invoking coroutine-related code from blocking world callbacks.

            Log.d(TAG, "current thread : ${Thread.currentThread().name}")

            val network = doNetWorkCall()


            // Switching from a IO To Main
            GlobalScope.launch(Dispatchers.Main) {
                Log.d(TAG, "current thread : ${Thread.currentThread().name}")
                text.text = network
            }

        }
    }

    suspend fun doNetWorkCall(): String {
        delay(3000L)
        return "Network Call 1"
    }

}