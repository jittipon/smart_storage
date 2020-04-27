package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_order.*

class order : AppCompatActivity() {

    override fun onBackPressed() {
        val i = Intent(this@order, info::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        btnback.setOnClickListener {
            val intent = Intent(this@order,info::class.java)
            startActivity(intent)

        }


        sendorder.setOnClickListener {
            val intent = Intent(this@order,ordercom::class.java)
            startActivity(intent)

        }




    }
}
