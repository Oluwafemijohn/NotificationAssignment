package com.example.notification

import android.app.Notification
import android.icu.number.NumberFormatter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var display: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        display = findViewById(R.id.textView)

        change()

    }
    private fun change(){
        val inactive = intent.getStringExtra("data")
        if(inactive != null){
            display.text = inactive
        }
    }
}