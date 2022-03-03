package com.example.finalgurbanisearcher

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LiveKirtanOnlineRadio : AppCompatActivity() {

    val audioArrayList = ArrayList<RadioAdapterData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_kirtan_online_radio)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRadioList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        var audioAdapter = RadioAdapter(this, audioArrayList)

        for (i  in 0..20){

            audioArrayList.add(RadioAdapterData("Channel ${i+1}"))

        }

        recyclerView.adapter = audioAdapter

        audioAdapter.onClick(object : RadioAdapter.OnNoteListener {

            override fun onNoteClick(position: Int) {
                when(position){
                    0->{
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.setData(Uri.parse("https://www.sikhnet.com/radio/western"))
                        startActivity(intent)
                    }
                    1->{
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.setData(Uri.parse("https://www.sikhnet.com/radio/classical"))
                        startActivity(intent)
                    }
                    2->{
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.setData(Uri.parse("https://www.sikhnet.com/radio/classical"))
                        startActivity(intent)
                    }
                    3->{
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.setData(Uri.parse("https://www.sikhnet.com/radio/radio/akhandpath"))
                        startActivity(intent)
                    }
                    4->{
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.setData(Uri.parse("https://www.sikhnet.com/radio/simran"))
                        startActivity(intent)
                    }
                    5->{
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.setData(Uri.parse("https://www.sikhnet.com/radio/western"))
                        startActivity(intent)
                    }
                    6->{
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.setData(Uri.parse("https://www.sikhnet.com/radio/akhandpath-english"))
                        startActivity(intent)
                    }
                    7->{
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.setData(Uri.parse("https://www.sikhnet.com/radio/katha-punjabi"))
                        startActivity(intent)
                    }
                }


            }
        })



    }




}
