package com.example.finalgurbanisearcher

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ShabadKosh :  AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shabadkosh)



        val bottomMenuBar: BottomNavigationView? = findViewById<BottomNavigationView>(R.id.bottomMenuBar)
        bottomMenuBar!!.selectedItemId=R.id.shabadkosh
        bottomMenuBar?.setOnNavigationItemSelectedListener {


            when (it.itemId) {
                R.id.home -> {
                    val i = Intent(this@ShabadKosh ,MainActivity::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.hukamnama -> {
                    val i = Intent(this@ShabadKosh ,HukamNama::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.restoreData -> {
                    val i = Intent(this@ShabadKosh,RestoreData::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.backData -> {
                    val i = Intent(this@ShabadKosh,BackupData::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.shabadkosh -> {
                    val i = Intent(this@ShabadKosh,ShabadKosh::class.java)
                    startActivity(i)
                    finish()
                }

            }
            true
        }

    }


//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val view: View = inflater.inflate(R.layout.shabadkosh, container, false)
//        return view
//    }
}