package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anto.Anto
import com.example.anto.ResponseAnto
import com.example.anto.ValueEventListener
import kotlinx.android.synthetic.main.activity_availablebox2a.*
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.activity_info2a.*
import kotlinx.android.synthetic.main.activity_info2a.pointerSpeedometer
import kotlinx.android.synthetic.main.activity_info2a.pointerSpeedometer2

class info2a : AppCompatActivity() {


    val reference = Anto.getInstance().getReference("fQ5cOLsk3e0AioI5o91oOTfAeCHmY81itFZvXrDI","LockerProject")
    val temp = reference.addChannel("temp2")
    val humid = reference.addChannel("Humid2")


    override fun onBackPressed() {
        val i = Intent(this@info2a, storage::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info2a)

        pointerSpeedometer.withTremble = false
        pointerSpeedometer2.withTremble = false

        var tempf : Float

        temp.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(responseAnto: ResponseAnto) {
                tempf = responseAnto.value.toFloat()
                pointerSpeedometer.speedTo(tempf);

                //showtemp.text = temp.toString()
                //showtemp.text = responseAnto.value+"°C"
            }

            override fun onCancelled(dataBaseError: String) {

                //showtemp.text = "Error inPut from ANto"
            }



        })
        var humidf :Float

        humid.addValueEventListener(object  : ValueEventListener {
            override fun onDataChange(responseAnto: ResponseAnto) {
                humidf = responseAnto.value.toFloat()
                pointerSpeedometer2.speedTo(humidf);

                //showhumid.text = responseAnto.value+"%"
            }

            override fun onCancelled(dataBaseError: String) {

                //showhumid.text = "Error inPut from ANto"
            }



        })

        backBtn2a.setOnClickListener {
            val intent = Intent(this@info2a,storage::class.java)
            startActivity(intent)

        }

        orderBtn2a.setOnClickListener {
            val intent = Intent(this@info2a,order::class.java)
            startActivity(intent)

        }






    }
}
