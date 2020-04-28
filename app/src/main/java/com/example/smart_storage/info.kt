package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info.*

class info : AppCompatActivity() {

    override fun onBackPressed() {
        val i = Intent(this@info, storage::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        btnback.setOnClickListener {
            val intent = Intent(this@info,storage::class.java)
            startActivity(intent)
        }

        orderBtn.setOnClickListener {
            val intent = Intent(this@info,order::class.java)
            startActivity(intent)

        }





    }
}