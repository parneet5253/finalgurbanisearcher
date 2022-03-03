package com.example.finalgurbanisearcher

import android.icu.util.Calendar
import java.util.*

class CalendarEvent {

    fun t (i:Int, j:Int, k:Int):java.util.Calendar{
        val p = java.util.Calendar.getInstance()
p.set(i,j,k)
      return p
    }

}