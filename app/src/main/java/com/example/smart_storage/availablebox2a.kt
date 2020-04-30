package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anto.Anto
import kotlinx.android.synthetic.main.activity_availablebox2a.*

class availablebox2a : AppCompatActivity() {

    val reference = Anto.getInstance().getReference("fQ5cOLsk3e0AioI5o91oOTfAeCHmY81itFZvXrDI","LockerProject")
    val namepro2 = reference.addChannel("productname2")
    val amount2 = reference.addChannel("amount2")
    val high2 = reference.addChannel("high2")
    val length2 = reference.addChannel("length2")

    override fun onBackPressed() {
        val i = Intent(this@availablebox2a, storage::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_availablebox2a)

        val name = productname2a.text
        val amount = amount2a.text
        val high = high2a.text
        val length = length2a.text

        submitBtn2a.setOnClickListener {
            val intent = Intent(this@availablebox2a,info2a::class.java)

            namepro2.setValue(name.toString())
            amount2.setValue(amount.toString())
            high2.setValue(high.toString())
            length2.setValue(length.toString())

            startActivity(intent)

        }

        backBtn.setOnClickListener {
            val intent = Intent(this@availablebox2a,storage::class.java)

            startActivity(intent)
        }
















    }
}
