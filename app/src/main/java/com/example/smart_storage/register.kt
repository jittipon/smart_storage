package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import kotlin.math.log


class register : AppCompatActivity() {

    var mAuth : FirebaseAuth? = null
    private  val TAG : String = "Register Activity"

    override fun onBackPressed() {
        val i = Intent(this@register, MainActivity::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

//        if(mAuth!!.currentUser != null){
//            startActivity(Intent(this@register,storage::class.java))
//            finish()
//        }

        back.setOnClickListener {
            val intent = Intent(this@register,MainActivity::class.java)
            startActivity(intent)

        }

        gotologin.setOnClickListener {
            val  intent = Intent(this@register,login::class.java)
            startActivity(intent)

        }

        signupBtn.setOnClickListener {
//            val intent = Intent(this@register,login::class.java)
//            startActivity(intent)
            val email = inputUser.text.toString().trim { it <= ' ' }
            val password = inputPass.text.toString().trim { it <= ' ' }

            if(email.isEmpty()){
                inputUser.error = "Please enter your email address"
                Log.d(TAG,"Email was empty!")
                return@setOnClickListener
            }
            if(password.isEmpty()){
                inputPass.error = "Please enter your password"
                Log.d(TAG,"Password was empty!")
                return@setOnClickListener
            }

            mAuth!!.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if (!task.isSuccessful){
                    Toast.makeText(applicationContext,"Authentication Failed: " + task.exception , Toast.LENGTH_SHORT).show()
                    //inputUser.error = "Authentication Failed: " + task.exception
                    Log.d(TAG,"Authentication Failed: "+ task.exception)
                } else {
                    Log.d(TAG,"Create account successfully!")
                    startActivity(Intent(this@register,login::class.java))
                    finish()
                }
            }

        }



    }
}
