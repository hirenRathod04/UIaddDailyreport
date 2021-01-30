package com.royalsoftsolutions.uiadddailyreport

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import java.text.SimpleDateFormat
import java.util.*

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity2 : AppCompatActivity() {
    private var title: String = ""

    private var context = this@MainActivity2

    //lateinit var binding: ActivityMainBinding
    private var userName: String = ""
    private val formatted = 0
    private var srNo = 1
    private   var serial_no : String =""
    private val myList = ArrayList<RecyclerItem>()
    private lateinit var myAdapter_m: MyAdepter
    private lateinit var ivBack : ImageView
    private lateinit var tvAddReport : TextView
    private lateinit var tvTodayDate : TextView
    private lateinit var etReport : EditText
    private lateinit var tvSr_No : EditText
    private lateinit var ciFileAttachment : CircleImageView
    private lateinit var btnAdd_Detalis : Button
    private lateinit var recyclerView : RecyclerView


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        ivBack = findViewById(R.id.ivBack)
        tvAddReport = findViewById(R.id.tvAddReport)
        tvTodayDate = findViewById(R.id.tvTodayDate)
        etReport = findViewById(R.id.etReport)
        ciFileAttachment = findViewById(R.id.ciFileAttachment)
        btnAdd_Detalis = findViewById(R.id.btnAdd_Detalis)
        recyclerView = findViewById(R.id.rvTodayReport)

        init()
        addListeners()
    }

    private fun addListeners() {
        ivBack.setOnClickListener {
            //onBackPressed()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnAdd_Detalis.setOnClickListener {
            val reportData = etReport.text.toString().trim()
             serial_number ()

            myList.add(RecyclerItem(serial_no, reportData, "", ""))
            srNo++
            myAdapter_m.updateList(myList)

        }
    }
    fun from_myadepter(){
        Toast.makeText(applicationContext,"deleted",Toast.LENGTH_SHORT).show()
       /* srNo = 0
        val reportData = etReport.text.toString().trim()
        myList.add(RecyclerItem(serial_no, reportData, "", ""))
        srNo++
        myAdapter_m.updateList(myList)*/
       /* dailyreportList = list
        notifyDataSetChanged()*/
    }
    private  fun serial_number() {
        val a = srNo.toString()
        val b = "."
        serial_no = a + b

    }

    private fun init() {
        //set today date
        val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        tvTodayDate.text = currentDateAndTime

        //clear list
        if (myList.isNotEmpty()) {
            myList.clear()
        }

        //initialize recyclerview
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        myAdapter_m = MyAdepter(context,myList)
        recyclerView.adapter = myAdapter_m
    }

}