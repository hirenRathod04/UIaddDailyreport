package com.royalsoftsolutions.uiadddailyreport

import java.text.SimpleDateFormat

class getActualTime{
    val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
    val currentDateAndTime: String = simpleDateFormat.format(java.util.Date())
}