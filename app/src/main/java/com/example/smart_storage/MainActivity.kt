package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var doubleBackToExitOnce:Boolean = false

    override fun onBackPressed() {
        if(doubleBackToExitOnce){
            super.onBackPressed()
            return
        }

        this.doubleBackToExitOnce = true

        //displays a toast message when user clicks exit button
        Toast.makeText(applicationContext,"please press again to exit ",Toast.LENGTH_SHORT).show()
        //displays the toast message for a while
        Handler().postDelayed({
            kotlin.run { doubleBackToExitOnce = false }
        }, 2000)

    }

    var mAuth : FirebaseAuth? = null
    private val TAG: String = "Main Activity"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

//        if(mAuth!!.currentUser != null){
//            Log.d(TAG,"Continue with: "+ mAuth!!.currentUser!!.email)
//            val i = Intent(this@MainActivity,com.example.smart_storage.register::class.java);
//            startActivity(i);
//        }

        signupBtn.setOnClickListener(){
            val i = Intent(this@MainActivity,com.example.smart_storage.register::class.java);
            startActivity(i);
        }
        loginBtn.setOnClickListener(){
            val i = Intent(this@MainActivity,com.example.smart_storage.login::class.java);
            startActivity(i);
        }
    }
}
