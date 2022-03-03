package com.example.finalgurbanisearcher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AudioAdapter (val context: Context,
                    private val mList: List<SongsClass>) :
    RecyclerView.Adapter<AudioAdapter.ViewHolder>() {

    open var onNoteListener: OnNoteListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.audio_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]


        holder.artists.text = ItemsViewModel.audioArtist
        holder.title.text = ItemsViewModel.audioTitle
        holder.points.text = timerConversion((ItemsViewModel.audioDuration).toLong()).toString()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(ItemView: View) :
        RecyclerView.ViewHolder(ItemView),
        View.OnClickListener {
        val artists: TextView = itemView.findViewById(R.id.artists)
        val title: TextView = itemView.findViewById(R.id.title)
        val points: TextView =itemView.findViewById(R.id.points)
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
    fun timerConversion(value: Long): String? {
        val audioTime: String
        val dur = value.toInt()
        val hrs = dur / 3600000
        val mns = dur / 60000 % 60000
        val scs = dur % 60000 / 1000
        audioTime = if (hrs > 0) {
            String.format("%02d:%02d:%02d", hrs, mns, scs)
        } else {
            String.format("%02d:%02d", mns, scs)
        }
        return audioTime
    }


}