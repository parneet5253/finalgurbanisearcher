package com.example.finalgurbanisearcher

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.IllegalStateException

class AudioPlayer: AppCompatActivity() {
    var current_pos: Double? = null
    var total_duration: Double? = null
    var audio_index = 0
    val mediaPlayer = MediaPlayer()
    val audioArrayList = ArrayList<SongsClass>()
    var seekBar: SeekBar? = null
    var audioName: TextView? = null
    var pause: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.audio_player)
        val bundle: Bundle? = intent.extras
        val p = bundle?.get("int")
        setAudio(p as Int)
    }

    fun setAudio(p:Int) {
        seekBar = findViewById<SeekBar>(R.id.PlayerSeekbar)
        audioName = findViewById<TextView>(R.id.audio_name)
        pause = findViewById<ImageView>(R.id.pause)

        getAudioFiles(contentResolver)
        fastForword()
        playAudio(p)



        seekBar!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

                current_pos = seekBar.progress.toDouble()
                mediaPlayer.seekTo(current_pos?.toInt()!!)
            }
        })

        mediaPlayer.setOnCompletionListener {
            audio_index++
            if (audio_index < audioArrayList!!.size) {
                playAudio(audio_index)
            } else {
                audio_index = 0
                playAudio(audio_index)
            }
        }
        if (!audioArrayList!!.isEmpty()) {
            playAudio(audio_index);
            prevAudio();
            nextAudio();
            setPause();
            fastForword();
        }

    }

    fun playAudio(pos: Int) {


        try {
            mediaPlayer.reset()
            mediaPlayer.setDataSource(this, audioArrayList!!.get(pos).audioUri)
            mediaPlayer.prepare()
            mediaPlayer.start()
            pause!!.setImageResource(R.drawable.pause3x)
            audioName!!.setText(audioArrayList!!.get(pos).audioTitle)
            audio_index = pos
        } catch (e: Exception) {
            e.printStackTrace()
        }
        setAudioProgress(current_pos as Double)
    }


    fun fastForword():Double{
        val fastForward= findViewById<ImageView>(R.id.fastBackword)
        current_pos=mediaPlayer.currentPosition.toDouble()

        fastForward.setOnClickListener{


            var current_pos1  =current_pos!!  +10.00

            current_pos=current_pos1



        }
        return current_pos as Double
    }


    fun setAudioProgress(current1:Double) {
        this.current_pos=current1
        val total = findViewById<TextView>(R.id.total)
        val current = findViewById<TextView>(R.id.current)

        //get the audio duration
        current_pos = mediaPlayer.currentPosition.toDouble()
        total_duration = mediaPlayer.duration.toDouble()

        //display the audio duration
        total.setText(timerConversion(total_duration!!.toLong()))
        current.setText(timerConversion(current_pos!!.toLong()))
        seekBar!!.setMax(total_duration!!.toInt())


        val handler = Handler()
        val runnable: Runnable = object : Runnable {
            override fun run() {
                try {
                    current_pos = mediaPlayer.currentPosition.toDouble()
                    current.setText(timerConversion(current_pos!!.toLong()))
                    seekBar!!.setProgress(current_pos!!.toInt())
                    handler.postDelayed(this, 1000)
                } catch (ed: IllegalStateException) {
                    ed.printStackTrace()
                }
            }
        }
        handler.postDelayed(runnable, 1000)
    }

    fun prevAudio() {
        val prev = findViewById<ImageView>(R.id.previous)

        prev.setOnClickListener {

            if (audio_index > 0) {
                audio_index--
                playAudio(audio_index)
            } else {
                audio_index = audioArrayList!!.size - 1
                playAudio(audio_index)
            }

        }
    }

    fun nextAudio() {
        val next = findViewById<ImageView>(R.id.next)

        next.setOnClickListener(View.OnClickListener {
            if (audio_index < audioArrayList!!.size - 1) {
                audio_index++
                playAudio(audio_index)
            } else {
                audio_index = 0
                playAudio(audio_index)
            }
        })
    }

    fun setPause() {
        pause!!.setOnClickListener(View.OnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                pause!!.setImageResource(R.drawable.musicplaybutton)
            } else {
                mediaPlayer.start()

                pause!!.setImageResource(R.drawable.pause3x)
            }
        })
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

    @SuppressLint("Range")
    fun getAudioFiles(contentResolver: ContentResolver) {
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val cursor = contentResolver.query(uri, null, null, null, null)

        if (cursor != null && cursor.moveToFirst()) {

            do {


                val title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
                val duration = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION))
                val url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))
                val artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST))

                val songsClass = SongsClass(title, duration, artist, Uri.parse(url))
                audioArrayList.add(songsClass)

            } while (cursor.moveToNext())

        }

    }
    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer != null) {
            mediaPlayer.release()
        }
    }
}