package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        regisbutton.setOnClickListener(){
            val i = Intent(this@MainActivity,com.example.smart_storage.register::class.java);
            startActivity(i);
        }
        loginbutton.setOnClickListener(){
            val i = Intent(this@MainActivity,com.example.smart_storage.login::class.java);
            startActivity(i);
        }
    }
}
