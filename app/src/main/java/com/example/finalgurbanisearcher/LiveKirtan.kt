package com.example.finalgurbanisearcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class LiveKirtan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.live_kirtan)

 val cardLocalFiles= findViewById<CardView>(R.id.cardLocalFiles)
val cardLiveRadio=findViewById<CardView>(R.id.cardLiveRadio)
        cardLocalFiles.setOnClickListener{
            val intent= Intent(applicationContext,SongList::class.java)
       startActivity(intent)
        }
        cardLiveRadio.setOnClickListener{
            val intent= Intent(applicationContext,LiveKirtanOnlineRadio::class.java)
            startActivity(intent)
        }
    }
}