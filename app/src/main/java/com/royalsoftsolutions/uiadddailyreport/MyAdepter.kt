package com.royalsoftsolutions.uiadddailyreport

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

class MyAdepter(
    private var context : Context,
    private var dailyreportList: ArrayList<RecyclerItem>) :
        RecyclerView.Adapter<MyAdepter.MyViewHolder>() {

    private lateinit var abc: MainActivity2
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.show_recyclerview, parent, false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val daily_r_details = dailyreportList[position]
        holder.report_text.text = daily_r_details.getTitle()
        holder.report_sr.text = (position+1).toString()
        holder.option_popupmenu.text = daily_r_details.getOption()
        holder.adepter_Rv_Delete.setOnClickListener{deleteItem(position)}
    }

    override fun getItemCount(): Int {
        return dailyreportList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var report_sr: TextView = view.findViewById(R.id.tvSr_No)
        var report_text: TextView = view.findViewById(R.id.tvDRreport)
        var attachment: CircleImageView = view.findViewById(R.id.ibtn_drattachment)
          var option_popupmenu: TextView = view.findViewById(R.id.txtOptionDigit)
         var adepter_Rv_Delete: ImageView = view.findViewById(R.id.Rv_Delete)
        var adepter_Rv_Edit: ImageView = view.findViewById(R.id.Rv_Edit)




    }

    fun updateList(list:ArrayList<RecyclerItem>){
        dailyreportList = list
        notifyDataSetChanged()
    }
    fun deleteItem(index: Int){
        dailyreportList.removeAt(index)
       // abc.from_myadepter()
        notifyDataSetChanged()
     //   Toast.makeText(context,"deleted", Toast.LENGTH_SHORT).show()
    }
}
