package com.example.finalgurbanisearcher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HymnAdapter(
    val context: Context,
    private val mList: ArrayList<EmpModelClass>
) :
    RecyclerView.Adapter<HymnAdapter.ViewHolder>() {

    open var onNoteListener: OnNoteListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hymn_card_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]


        holder.title.text = ItemsViewModel.userName1
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(ItemView: View) :
        RecyclerView.ViewHolder(ItemView),
        View.OnClickListener {
        val title: TextView = itemView.findViewById(R.id.textViewHymntop)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onNoteListener?.onNoteClick(adapterPosition,title.text.toString())

        }
    }

    fun onClick(onNoteListener: OnNoteListener) {
        this.onNoteListener = onNoteListener
    }


    interface OnNoteListener {

        fun onNoteClick(position: Int,title:String)
    }
}