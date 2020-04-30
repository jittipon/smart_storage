package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class login : AppCompatActivity() {

    var mAuth : FirebaseAuth? = null
    private val TAG: String = "Login Acitvity"
    //hello

    override fun onBackPressed() {
        val i = Intent(this@login, MainActivity::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

//        if(mAuth!!.currentUser != null){
//            startActivity(Intent(this@login,storage::class.java))
//            finish()
//        }

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
            val email = getuser.text.toString().trim {it <= ' '}
            val password = getpass.text.toString().trim {it <= ' '}

            if(email.isEmpty()){
                getuser.error = "Please enter your email address"
                Log.d(TAG,"Email was empty!")
                return@setOnClickListener
            }
            if(password.isEmpty()){
                getuser.error = "Please enter your password"
                Log.d(TAG,"Password was empty!")
                return@setOnClickListener
            }

            mAuth!!.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if(!task.isSuccessful){
                    Toast.makeText(applicationContext,"Authentication Failed: " + task.exception ,Toast.LENGTH_SHORT).show()
                   // getuser.error = "Authentication Failed: " + task.exception
                    Log.d(TAG,"Authentication Failed: "+ task.exception)
                } else {
                    Log.d(TAG,"Sign in successfully!")
                    startActivity(Intent(this@login,storage::class.java))
                    finish()
                }
            }
//            val user = getuser.text.toString()
//            val pass = getpass.text.toString()


//            if (user==user1)
//            {
//                val intent = Intent(this@login,storage::class.java)
//                intent.putExtra("user",user)
//                intent.putExtra("pass",pass)
//
//                startActivity(intent)
//            }
//            else
//            {
//                Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_SHORT).show()
//
//            }


        }


            }
        }

