package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*


class register : AppCompatActivity() {

    override fun onBackPressed() {
        val i = Intent(this@register, MainActivity::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        back.setOnClickListener {
            val intent = Intent(this@register,MainActivity::class.java)
            startActivity(intent)
        }

        gotologin.setOnClickListener {
            val  intent = Intent(this@register,login::class.java)
            startActivity(intent)
        }



    }
}
