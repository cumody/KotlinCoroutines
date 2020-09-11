package com.mahmoudshaaban.kotlincoroutines

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

        // Global scope means every coroutines needs to be started in a certain scope
        // global Scope Means this coroutines will live as long as our app does and if certain job finishes it will be destroyed
        // and not kept alive until the app dies
        // global scope means it's executed asyc
        GlobalScope.launch {
            // Note : if main thread finishes his work before coroutines executed it will not executed
            delay(3000L)
            Log.d(TAG, "Coroutines say hello from thread ${Thread.currentThread().name}")
        }
        Log.d(TAG, "Coroutines say hello from thread ${Thread.currentThread().name}")

    }
}