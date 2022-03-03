package com.example.finalgurbanisearcher

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CompiledHymns : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compiled_hymns)
        val floatingButton =
            findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.floatingButton)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCompiledHymns)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val databaseHandler = CompiledHymnStorage(this)

        var audioArrayList = databaseHandler.viewEmployee()

        var audioAdapter = HymnAdapter(this, audioArrayList)

        audioAdapter.onClick(object : HymnAdapter.OnNoteListener {

            override fun onNoteClick(position: Int, title: String) {

                val dialogBuilder = AlertDialog.Builder(this@CompiledHymns)
                val inflater = this@CompiledHymns.layoutInflater
                val dialogView = inflater.inflate(R.layout.delete_dialog, null)
                dialogBuilder.setView(dialogView)


                dialogBuilder.setPositiveButton("Delete", DialogInterface.OnClickListener { _, _ ->

                    val deleteId = title
                    if (deleteId.trim() != "") {
                        val status = databaseHandler.deleteEmployee(title)
                        if (status > -1) {
                            audioArrayList=databaseHandler.viewEmployee()
                            audioAdapter = HymnAdapter(this@CompiledHymns, audioArrayList)

                            Toast.makeText(applicationContext, "record deleted", Toast.LENGTH_LONG)
                                .show()
                            recreate()
                        }
                    } else {
                        Toast.makeText(
                            applicationContext,
                            " name  cannot be blank",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
                dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ ->
                    //pass
                })
                val b = dialogBuilder.create()
                b.show()
            }
        })
        val empArrayName = Array<String>(audioArrayList.size) { "null" }
        var index = 0
        for (e in audioArrayList) {
            empArrayName[index] = e.userName1
            index++
        }
        recyclerView.adapter = audioAdapter


        floatingButton.setOnClickListener {
            val intent = Intent(this, CompiledHymnOnclickEdit::class.java)
            startActivity(intent)
            finish()
        }

    }
}