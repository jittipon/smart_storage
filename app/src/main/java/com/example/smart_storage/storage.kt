package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.anto.Anto
import com.example.anto.ResponseAnto
import com.example.anto.ValueEventListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_storage.*

class storage : AppCompatActivity() {

    var mAuth : FirebaseAuth? = null
    var mAuthListener : FirebaseAuth.AuthStateListener? = null
    private  val TAG : String = "Result Activity"

    val reference = Anto.getInstance().getReference("fQ5cOLsk3e0AioI5o91oOTfAeCHmY81itFZvXrDI","LockerProject")
    val check = reference.addChannel("storage")
    val check2 = reference.addChannel("storage2")

    lateinit var showuser: TextView
    var backcount = 0
    override fun onBackPressed() {

        backcount = backcount + 1
        Toast.makeText(applicationContext,"press again to logout", Toast.LENGTH_SHORT).show()
        if (backcount>1)
        {
            mAuth!!.signOut()
            Toast.makeText(applicationContext,"log out success", Toast.LENGTH_SHORT).show()
            val i = Intent(this@storage, MainActivity::class.java)
            startActivity(i)
            backcount = 0
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        //val user = mAuth!!.currentUser

        //username.text = user!!.email

        //showuser = findViewById(R.id.username)

        //val username = intent.getStringExtra("user")
        //showuser.text = username

        mAuthListener = FirebaseAuth.AuthStateListener {  firebaseAuth ->
            val users = firebaseAuth.currentUser
            if(users == null){
                startActivity(Intent(this@storage,MainActivity::class.java))
                finish()
            }
        }

        check.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(responseAnto: ResponseAnto) {
                var status = responseAnto.value
                if (status == "1")
                {
                    box1bar.setImageResource(R.drawable.red)

                }
                else
                {
                    box1bar.setImageResource(R.drawable.green)

                }
            }

            override fun onCancelled(dataBaseError: String) {
            }

        })

        check2.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(responseAnto: ResponseAnto) {
                var status = responseAnto.value
                if (status == "1")
                {
                    box2bar.setImageResource(R.drawable.red)

                }
                else
                {
                    box2bar.setImageResource(R.drawable.green)

                }
            }

            override fun onCancelled(dataBaseError: String) {

            }

        })


        box1.setOnClickListener {
            val intent = Intent(this@storage,availablebox::class.java)
            startActivity(intent)
        }
        box2.setOnClickListener {
            val intent = Intent(this@storage,availablebox2a::class.java)
            startActivity(intent)
        }

    }

//    override fun onStart(){
//        super.onStart()
//        mAuth!!.addAuthStateListener { mAuthListener }
//    }
//
//    override fun onStop() {
//        super.onStop()
//        if (mAuthListener != null) {mAuth!!.removeAuthStateListener { mAuthListener }}
//    }


}
