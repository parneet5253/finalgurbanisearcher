package com.example.finalgurbanisearcher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RadioAdapter (val context: Context,
                    private val mList: List<RadioAdapterData>) :
    RecyclerView.Adapter<RadioAdapter.ViewHolder>() {

    open var onNoteListener: OnNoteListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.radio_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]


        holder.title.text = ItemsViewModel.Title
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(ItemView: View) :
        RecyclerView.ViewHolder(ItemView),
        View.OnClickListener {
        //        val artists: TextView = itemView.findViewById(R.id.artists)
        val title: TextView = itemView.findViewById(R.id.titleRadio)

        //        val points: TextView =itemView.findViewById(R.id.points)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onNoteListener?.onNoteClick(adapterPosition)

        }
    }

    fun onClick(onNoteListener: OnNoteListener) {
        this.onNoteListener = onNoteListener
    }


    interface OnNoteListener {

        fun onNoteClick(position: Int)


    }
}