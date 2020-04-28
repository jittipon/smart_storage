package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_availablebox.*

class availablebox : AppCompatActivity() {

    override fun onBackPressed() {
        val i = Intent(this@availablebox, storage::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_availablebox)

        btnback.setOnClickListener {
            val intent = Intent(this@availablebox,storage::class.java)
            startActivity(intent)
        }

        submitBtn1a.setOnClickListener {
            val intent = Intent(this@availablebox,info::class.java)
            startActivity(intent)
        }











    }
}
