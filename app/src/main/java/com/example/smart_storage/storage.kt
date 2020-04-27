package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_storage.*

class storage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)


        backBtn.setOnClickListener {
            val intent = Intent(this@storage,MainActivity::class.java)
            startActivity(intent)
        }
        box1.setOnClickListener {
            val intent = Intent(this@storage,availablebox::class.java)
            startActivity(intent)
        }
        box2.setOnClickListener {
            val intent = Intent(this@storage,availablebox::class.java)
            startActivity(intent)
        }










    }
}
