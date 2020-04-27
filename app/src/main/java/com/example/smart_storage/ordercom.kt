package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ordercom.*

class ordercom : AppCompatActivity() {

    override fun onBackPressed() {
        val i = Intent(this@ordercom, info::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordercom)


        btnback.setOnClickListener {
            val intent = Intent(this@ordercom,order::class.java)
            startActivity(intent)
        }












    }
}
