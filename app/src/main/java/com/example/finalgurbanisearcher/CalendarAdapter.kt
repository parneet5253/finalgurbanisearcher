package com.example.finalgurbanisearcher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalendarAdapter(
    val context: Context,
    private val mList: List<CalendarDataModelClass>
) :
    RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_calendar_event, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]


        holder.eventName.text = ItemsViewModel.date
        holder.Date.text = ItemsViewModel.event
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(ItemView: View) :
        RecyclerView.ViewHolder(ItemView) {
        val eventName: TextView = itemView.findViewById(R.id.Details)
        val Date: TextView = itemView.findViewById(R.id.date_text)
    }
}
