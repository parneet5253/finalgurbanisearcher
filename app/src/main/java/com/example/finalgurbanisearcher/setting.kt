package com.example.finalgurbanisearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val cardhelpvideos = findViewById<CardView>(R.id.helpvideos)
        cardhelpvideos.setOnClickListener{

            var intent = Intent(applicationContext,HelpVideos::class.java)
            startActivity(intent)
        }
    }
}