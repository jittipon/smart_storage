package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
