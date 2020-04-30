package com.example.smart_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anto.Anto
import com.example.anto.ResponseAnto
import com.example.anto.ValueEventListener
import kotlinx.android.synthetic.main.activity_info.*

class info : AppCompatActivity() {


    val reference = Anto.getInstance().getReference("K3yltBNveN4QGwtE8I5XngNDTwxZM9hTWswzyshK","test")
    val temp = reference.addChannel("temp")
    val humid = reference.addChannel("humid")


//MON
//    val reference = Anto.getInstance().getReference("K3yltBNveN4QGwtE8I5XngNDTwxZM9hTWswzyshK","test")
//    val temp = reference.addChannel("temp")
//    val humid = reference.addChannel("humid")

//    Vnus
//    val reference = Anto.getInstance().getReference("smyz3PVfOXvdlDnNV1STU3ejSYffWtwFxbNGawHe","SmartStorage")
//    val instock = reference.addChannel("Amount1")
//    val temp = reference.addChannel("Temperature1")
//    val humid = reference.addChannel("Humidity1")

    override fun onBackPressed() {
        val i = Intent(this@info, storage::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        pointerSpeedometer.withTremble = false
        pointerSpeedometer2.withTremble = false

        var amount:Int

//        instock.addValueEventListener(object :ValueEventListener{
//            override fun onDataChange(responseAnto: ResponseAnto) {
//                showinstock.text = responseAnto.value
//
//            }
//
//            override fun onCancelled(dataBaseError: String) {
//                TODO("Not yet implemented")
//
//            }
//
//        })

        var tempf : Float

        temp.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(responseAnto: ResponseAnto) {
                tempf = responseAnto.value.toFloat()
                pointerSpeedometer.speedTo(tempf);

                //--showtemp.text = temp.toString()
                //--showtemp.text = responseAnto.value+"°C"
            }

            override fun onCancelled(dataBaseError: String) {

                //--showtemp.text = "Error inPut from ANto"
            }

        })
        var humidf :Float

        humid.addValueEventListener(object  : ValueEventListener{
            override fun onDataChange(responseAnto: ResponseAnto) {
                humidf = responseAnto.value.toFloat()
                pointerSpeedometer2.speedTo(humidf);

                //--showhumid.text = responseAnto.value+"%"
            }

            override fun onCancelled(dataBaseError: String) {

                //--showhumid.text = "Error inPut from ANto"
            }

        })

        btnback.setOnClickListener {
            val intent = Intent(this@info,storage::class.java)
            startActivity(intent)
        }

        orderBtn.setOnClickListener {
            val intent = Intent(this@info,order::class.java)
            startActivity(intent)

        }

    }
}
