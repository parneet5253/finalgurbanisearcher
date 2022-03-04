package com.example.finalgurbanisearcher

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class RestoreData :  AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restore_data)



        val bottomMenuBar: BottomNavigationView? = findViewById<BottomNavigationView>(R.id.bottomMenuBar)
        bottomMenuBar!!.selectedItemId=R.id.restoreData
        bottomMenuBar?.setOnNavigationItemSelectedListener {


            when (it.itemId) {
                R.id.home -> {
                    val i = Intent(this@RestoreData ,MainActivity::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.hukamnama -> {
                    val i = Intent(this@RestoreData,HukamNama::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.restoreData -> {
                    val i = Intent(this@RestoreData,RestoreData::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.backData -> {
                    val i = Intent(this@RestoreData,BackupData::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.shabadkosh -> {
                    val i = Intent(this@RestoreData,ShabadKosh::class.java)
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
//        val view: View = inflater.inflate(R.layout.restore_data, container, false)
//        return view
//    }
}