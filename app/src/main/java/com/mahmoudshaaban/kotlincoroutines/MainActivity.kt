package com.mahmoudshaaban.kotlincoroutines

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       Next.setOnClickListener(){
           GlobalScope.launch {
               while (true){
               delay(1000L)
                   Log.d(TAG,"still running ")
               }
           }

           GlobalScope.launch {
               delay(5000L)
               Intent(this@MainActivity,SecondActivity::class.java).also {
                   startActivity(it)
                   finish()
               }
           }
       }
    }
}