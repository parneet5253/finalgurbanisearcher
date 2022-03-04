package com.example.finalgurbanisearcher

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HukamNama :  AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hukamnama)




        val bottomMenuBar: BottomNavigationView? = findViewById<BottomNavigationView>(R.id.bottomMenuBar)
        bottomMenuBar!!.selectedItemId=R.id.hukamnama
        bottomMenuBar?.setOnNavigationItemSelectedListener {


            when (it.itemId) {
                R.id.home -> {
                    val i = Intent(this@HukamNama ,MainActivity::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.hukamnama -> {
                    val i = Intent(this@HukamNama ,HukamNama::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.restoreData -> {
                    val i = Intent(this@HukamNama,RestoreData::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.backData -> {
                    val i = Intent(this@HukamNama,BackupData::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.shabadkosh -> {
                    val i = Intent(this@HukamNama,ShabadKosh::class.java)
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
//        val view: View = inflater.inflate(R.layout.hukamnama, container, false)
//        return view
//    }
}