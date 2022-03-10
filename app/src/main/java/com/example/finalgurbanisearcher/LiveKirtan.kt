package com.example.finalgurbanisearcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView

class LiveKirtan : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.live_kirtan)

            val bottomMenuBar: BottomNavigationView? = findViewById<BottomNavigationView>(R.id.bottomMenuBar)
            bottomMenuBar?.setOnNavigationItemSelectedListener {

                when (it.itemId) {
                    R.id.home -> {
                        val i = Intent(this@LiveKirtan  ,MainActivity::class.java)
                        startActivity(i)
                        finish()
                    }
                    R.id.hukamnama -> {
                        val i = Intent(this@LiveKirtan  ,HukamNama::class.java)
                        startActivity(i)
                        finish()
                    }
                    R.id.restoreData -> {
                        val i = Intent(this@LiveKirtan ,RestoreData::class.java)
                        startActivity(i)
                        finish()
                    }
                    R.id.backData -> {
                        val i = Intent(this@LiveKirtan ,BackupData::class.java)
                        startActivity(i)
                        finish()
                    }
                    R.id.shabadkosh -> {
                        val i = Intent(this@LiveKirtan ,ShabadKosh::class.java)
                        startActivity(i)
                        finish()
                    }

                }
                true
            }

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