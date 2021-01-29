package com.royalsoftsolutions.uiadddailyreport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdepter(private var dailyreportList: List<RecyclerItem>) :
        RecyclerView.Adapter<MyAdepter.MyViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.show_recyclerview, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val daily_r_details = dailyreportList[position]
        holder.report_text.text = daily_r_details.getTitle()
        holder.report_sr.text = daily_r_details.getno()
        holder.option_popupmenu.text = daily_r_details.getOption()
    }

    override fun getItemCount(): Int {
        return dailyreportList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var report_sr: TextView = view.findViewById(R.id.tvSr_No)
        var report_text: TextView = view.findViewById(R.id.tvDRreport)
        var attachment: CircleImageView = view.findViewById(R.id.ibtn_drattachment)
        var option_popupmenu: TextView = view.findViewById(R.id.txtOptionDigit)
    }

    fun updateList(list:List<RecyclerItem>){
        dailyreportList = list
        notifyDataSetChanged()
    }
}
