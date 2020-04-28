package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_availablebox2a.*
import kotlinx.android.synthetic.main.activity_info2a.*

class info2a : AppCompatActivity() {


    override fun onBackPressed() {
        val i = Intent(this@info2a, storage::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info2a)

        backBtn2a.setOnClickListener {
            val intent = Intent(this@info2a,storage::class.java)
            startActivity(intent)

        }

        orderBtn2a.setOnClickListener {
            val intent = Intent(this@info2a,order::class.java)
            startActivity(intent)

        }






    }
}
