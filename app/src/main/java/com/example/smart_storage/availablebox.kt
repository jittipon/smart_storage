package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.anto.Anto
import com.example.anto.ResponseAnto
import com.example.anto.ValueEventListener
import kotlinx.android.synthetic.main.activity_availablebox.*
import kotlinx.android.synthetic.main.activity_availablebox2a.*

class availablebox : AppCompatActivity() {

    val reference = Anto.getInstance().getReference("fQ5cOLsk3e0AioI5o91oOTfAeCHmY81itFZvXrDI","LockerProject")
    val namepro1 = reference.addChannel("productname1")
    val amount1 = reference.addChannel("amount1")
    val high1 = reference.addChannel("high1")
    val length1 = reference.addChannel("length1")

    override fun onBackPressed() {
        val i = Intent(this@availablebox, storage::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_availablebox)

        val name = productname1a.text
        val amount = amount1a.text
        val high = high1a.text
        val length = length1a.text


        submitBtn1a.setOnClickListener {

            if(name.toString().isEmpty()){
                productname1a.error = "Please enter product name!"
                return@setOnClickListener
            }
            if(amount.toString().isEmpty()){
                amount1a.error = "Please enter amount!"
                return@setOnClickListener
            }
            if(high.toString().isEmpty()){
                high1a.error = "Please enter height of product!"
                return@setOnClickListener
            }
            if(length.toString().isEmpty()){
                length1a.error = "Please enter lenght of product!"
                return@setOnClickListener
            }

            val intent = Intent(this@availablebox,info::class.java)
            namepro1.setValue(name.toString())
            amount1.setValue(amount.toString())
            high1.setValue(high.toString())
            length1.setValue(length.toString())


            startActivity(intent)
        }

        btnback.setOnClickListener {
            val intent = Intent(this@availablebox,storage::class.java)
            startActivity(intent)
        }






    }
}
