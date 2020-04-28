package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_storage.*

class storage : AppCompatActivity() {

    lateinit var showuser: TextView
    var backcount = 0
    override fun onBackPressed() {

        backcount = backcount + 1
        Toast.makeText(applicationContext,"press again to logout", Toast.LENGTH_SHORT).show()
        if (backcount>1)
        {
            Toast.makeText(applicationContext,"log out success", Toast.LENGTH_SHORT).show()
            val i = Intent(this@storage, MainActivity::class.java)
            startActivity(i)
            backcount = 0
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        showuser = findViewById(R.id.username)

        val username = intent.getStringExtra("user")
        showuser.text = username


        box1.setOnClickListener {
            val intent = Intent(this@storage,availablebox::class.java)
            startActivity(intent)
        }
        box2.setOnClickListener {
            val intent = Intent(this@storage,availablebox2a::class.java)
            startActivity(intent)
        }



    }
}
