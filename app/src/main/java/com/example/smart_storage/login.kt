package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*


class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        backbutton.setOnClickListener {
            val i = Intent(this@login, MainActivity::class.java)
            startActivity(i)
        }


        signup.setOnClickListener {
            val intent = Intent(this@login,register::class.java)
            startActivity(intent)
        }


            }
        }

