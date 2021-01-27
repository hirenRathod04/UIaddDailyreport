package com.royalsoftsolutions.uiadddailyreport

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity2 : AppCompatActivity() {

    private var context = this@MainActivity2
    //lateinit var binding: ActivityMainBinding
    private var userName : String = ""
      private val formatted = 0
  //  private val element = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val ivBack :ImageView = findViewById(R.id.ivBack)
       val tvAddReport : TextView = findViewById(R.id.tvAddReport)
        val tvTodayDate = findViewById(R.id.tvTodayDate) as TextView
      val  etReport = findViewById(R.id.etReport) as EditText
        val ciFileAttachment = findViewById(R.id.ciFileAttachment) as CircleImageView
        val btnAdd_Detalis = findViewById(R.id.btnAdd_Detalis) as Button
        val rvTodayReport = findViewById(R.id.rvTodayReport) as RecyclerView

        /*val array1 = arrayOf(1,2,3,4)
        for(element in array1){
            //println(element)

            tvAddReport.text =  element.toString()
        }*/


        val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        tvTodayDate.text = currentDateAndTime

        init()
        ivBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }


    private fun init() {


    }

}