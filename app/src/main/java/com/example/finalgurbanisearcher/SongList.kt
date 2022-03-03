package com.example.finalgurbanisearcher

import android.annotation.SuppressLint
import android.bluetooth.BluetoothGattCharacteristic
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SongList : AppCompatActivity() {
    val audioArrayList = ArrayList<SongsClass>()

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.song_list)


        if (checkPermission()) {
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager
            val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
            val cursor = contentResolver.query(uri, null, null, null, null)


            if (cursor != null && cursor.moveToFirst()) {

                do {


                    val title =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
                    val duration =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION))
                    val url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))
                    val artist =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST))

                    val songsClass = SongsClass(title, duration, artist, Uri.parse(url))
                    audioArrayList.add(songsClass)

                } while (cursor.moveToNext())

            }


            var audioAdapter = AudioAdapter(this, audioArrayList)

            recyclerView.adapter = audioAdapter

            audioAdapter.onClick(object : AudioAdapter.OnNoteListener {

                override fun onNoteClick(position: Int) {
                    val intent = Intent(applicationContext, AudioPlayer::class.java)
                    intent.putExtra("int", position)
                    startActivity(intent)
                }
            })

        }
    }


    fun checkPermission(): Boolean {
        val READ_EXTERNAL_PERMISSION =
            ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
        if (READ_EXTERNAL_PERMISSION != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                BluetoothGattCharacteristic.PERMISSION_READ
            )
            return false
        }
        return true
    }


}
