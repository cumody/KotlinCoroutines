package com.mahmoudshaaban.kotlincoroutines

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Delay
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            // suspend functions it can be executed in another suspend fun or inside the coroutines
            // it can not be called in main thread

            // it will be delayed for 6 seconds b/c in called from the same coroutines
            val network = doNetWorkCall()
            val network2 = doNetWorkCall2()

            Log.d(TAG,network)
            Log.d(TAG,network2)
        }
    }

    suspend fun doNetWorkCall(): String {
        delay(3000L)
        return "Network Call 1"
    }

    suspend fun doNetWorkCall2(): String {
        delay(3000L)
        return "Network Call 2"

    }
}