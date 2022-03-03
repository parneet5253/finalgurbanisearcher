package com.example.finalgurbanisearcher

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class CompiledHymnStorage(context: Context?):SQLiteOpenHelper(context,storageDb,null,dataVersion) {
    companion object{
        private val dataVersion = 2
        private val storageDb = "storage.db"
        private val tableStorage = "tableStorage"
        private val column = "columnStorage"

    }

    override fun onCreate(db: SQLiteDatabase) {
val p = ("CREATE TABLE " + tableStorage + "("+column + " TEXT"+")")

db.execSQL(p)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {



        db!!.execSQL("DROP TABLE IF EXISTS " + tableStorage)
        onCreate(db)

    }

    fun addEmployee(emp: EmpModelClass): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(column, emp.userName1) // EmpModelClass Name

        val success = db.insert(tableStorage, null, contentValues)
        db.close() // Closing database connection
        return success
    }

    @SuppressLint("Range")
    fun viewEmployee(): ArrayList<EmpModelClass> {
        val empList: ArrayList<EmpModelClass> = ArrayList<EmpModelClass>()
        val selectQuery = "SELECT  * FROM ${tableStorage}"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var userName: String

        if (cursor.moveToFirst()) {
            do {

                userName = cursor.getString(cursor.getColumnIndex("columnStorage"))
                val emp = EmpModelClass( userName1 = userName)
                empList.add(emp)
            } while (cursor.moveToNext())
        }
        return empList
    }

    fun deleteEmployee(emp: String): Int {
        val t = arrayOf(emp)
        val db = this.writableDatabase
        val success = db.delete(tableStorage,"columnStorage=?",t)
        db.close() // Closing database connection
        return success
    }


}