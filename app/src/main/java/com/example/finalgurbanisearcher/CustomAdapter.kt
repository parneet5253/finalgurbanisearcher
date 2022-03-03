package com.example.finalgurbanisearcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<ItemsViewModel>,val mOnNoteListener: OnNoteListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view,mOnNoteListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        holder.imageView.setImageResource(ItemsViewModel.image)

        holder.textView.text = ItemsViewModel.text
        holder.textView1.text = ItemsViewModel.text1

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View, val onNoteListener: OnNoteListener) : RecyclerView.ViewHolder(ItemView),View.OnClickListener {

        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val textView1: TextView = itemView.findViewById(R.id.textView2)

init{
    itemView.setOnClickListener(this)
}

        override fun onClick(v: View?) {
            onNoteListener.onNoteClick(adapterPosition)

        }


    }

public  interface OnNoteListener{

fun onNoteClick(position: Int)


 }


}



