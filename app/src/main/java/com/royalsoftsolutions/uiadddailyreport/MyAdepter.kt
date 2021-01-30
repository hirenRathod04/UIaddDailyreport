package com.royalsoftsolutions.uiadddailyreport

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.icu.text.CaseMap
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
        holder.adepter_Rv_Edit.setOnClickListener { edit() }
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
        fun edit(){


        }
    fun updateList(list:ArrayList<RecyclerItem>){
        dailyreportList = list
        notifyDataSetChanged()
    }

    fun deleteItem(index: Int)
    {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(context)
        alertDialog.setTitle("Be Alert!")
        alertDialog.setMessage("Are you sure you want to Delete this Report?")

        alertDialog.setPositiveButton(
            "yes"
        ) { _, _ ->  delete(index);Toast.makeText(context, "Deleted Report.", Toast.LENGTH_LONG).show()
        }
        alertDialog.setNegativeButton(
            "No"
        ) { _, _ ->  }

        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }
fun delete(index: Int){
    dailyreportList.removeAt(index)
    notifyDataSetChanged()
  /*  if(context is MainActivity2){
        (context as MainActivity2).from_myadepter()
    }*/

}

      //val my_dilog = AlertDialog.Builder(context)





}
