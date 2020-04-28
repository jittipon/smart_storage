package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_availablebox2a.*

class availablebox2a : AppCompatActivity() {

    override fun onBackPressed() {
        val i = Intent(this@availablebox2a, storage::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_availablebox2a)

        backBtn.setOnClickListener {
            val intent = Intent(this@availablebox2a,storage::class.java)
            startActivity(intent)

        }

        submitBtn2a.setOnClickListener {
            val intent = Intent(this@availablebox2a,info2a::class.java)
            startActivity(intent)

        }














    }
}
