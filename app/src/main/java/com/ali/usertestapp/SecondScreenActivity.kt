package com.ali.usertestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        val name = intent.getStringExtra("name")

        val textViewName = findViewById<TextView>(R.id.tv_name)
        textViewName.text = name

        val btnChooseUser = findViewById<Button>(R.id.btn_choose_user)
        btnChooseUser.setOnClickListener {
            val intent = Intent(this, ThirdScreenActivity::class.java)
            startActivity(intent)
        }
    }
}