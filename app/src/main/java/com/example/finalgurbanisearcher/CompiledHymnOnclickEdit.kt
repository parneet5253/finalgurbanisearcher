package com.example.finalgurbanisearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast

class CompiledHymnOnclickEdit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compiled_hymn_onclick_edit)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.hymn_menu, menu);

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

when(item.itemId) {

    R.id.searchHymn -> {
addText()
val intent = Intent(this@CompiledHymnOnclickEdit,CompiledHymns::class.java)
        startActivity(intent)
        finish()
    }
}
        return super.onOptionsItemSelected(item)
    }
fun addText() {
    val name = findViewById<EditText>(R.id.HymnEdit)
    val nameNew=name.text.toString()

    val databaseHandler = CompiledHymnStorage(this@CompiledHymnOnclickEdit)
    if (nameNew.trim() != "") {

        val status = databaseHandler.addEmployee(EmpModelClass(nameNew))
        if (status > -1) {
            Toast.makeText(this@CompiledHymnOnclickEdit, "record save", Toast.LENGTH_LONG).show()

            name.text.clear()


        } else {
            Toast.makeText(
                this@CompiledHymnOnclickEdit,
                " name  cannot be blank",
                Toast.LENGTH_LONG
            ).show()


        }
    }
}
}