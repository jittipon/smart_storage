package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class login : AppCompatActivity() {
    //hello

    override fun onBackPressed() {
        val i = Intent(this@login, MainActivity::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val user1 = "admin"
        val pass1 = "123456"

        backbutton.setOnClickListener {
            val i = Intent(this@login, MainActivity::class.java)
            startActivity(i)
        }

        signup.setOnClickListener {
            val intent = Intent(this@login,register::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            val user = getuser.text.toString()
            val pass = getpass.text.toString()


            if (user==user1)
            {
                val intent = Intent(this@login,storage::class.java)
                intent.putExtra("user",user)
                intent.putExtra("pass",pass)

                startActivity(intent)
            }
            else
            {
                Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_SHORT).show()

            }


        }


            }
        }

