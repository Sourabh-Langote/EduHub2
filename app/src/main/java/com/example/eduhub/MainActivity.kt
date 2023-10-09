package com.example.eduhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import loginModule.LoginPage

class MainActivity : AppCompatActivity() {

    lateinit var tv_id: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_id = findViewById(R.id.tv_id)

        var intent = Intent(this@MainActivity, LoginPage::class.java)
        startActivity(intent)
    }
}