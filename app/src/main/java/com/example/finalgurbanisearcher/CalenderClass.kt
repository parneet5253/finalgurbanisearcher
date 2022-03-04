package com.example.finalgurbanisearcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.applandeo.materialcalendarview.EventDay
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.SimpleDateFormat
import java.util.*

class CalenderClass : AppCompatActivity() {
    var  t:Int?=dateFormatMonth(Calendar.getInstance())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calender)



        val bottomMenuBar: BottomNavigationView? = findViewById<BottomNavigationView>(R.id.bottomMenuBar)
        bottomMenuBar?.setOnNavigationItemSelectedListener {


            when (it.itemId) {
                R.id.home -> {
                    val i = Intent(this@CalenderClass ,MainActivity::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.hukamnama -> {
                    val i = Intent(this@CalenderClass ,HukamNama::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.restoreData -> {
                    val i = Intent(this@CalenderClass,RestoreData::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.backData -> {
                    val i = Intent(this@CalenderClass,BackupData::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.shabadkosh -> {
                    val i = Intent(this@CalenderClass,ShabadKosh::class.java)
                    startActivity(i)
                    finish()
                }

            }
            true
        }


        val calender =
            findViewById<com.applandeo.materialcalendarview.CalendarView>(R.id.calendar)
        calAll(t!!)
        calender.setOnForwardPageChangeListener {

            t = t!! + 1
            calAll(t!!)
        }

        calender.setOnPreviousPageChangeListener {
            t = t!! - 1

            calAll(t!!)

        }

    }
    fun dateFormat(cal: Calendar): String {

        val date = cal.time

        val format1 = SimpleDateFormat("LLLL dd,  yyyy")

        val date1 = format1.format(date)

        return date1.toString()

    }

    fun dateFormatMonth(cal: Calendar): Int {

        val date = cal.time

        val format1 = SimpleDateFormat("MM")

        val date1 = format1.format(date)

        return ((date1.toInt())-1)

    }



    fun calAll(t:Int):Int{
        val calender =
            findViewById<com.applandeo.materialcalendarview.CalendarView>(R.id.calendar)

        val recyclerView = findViewById<RecyclerView>(R.id.event_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val n = CalendarEvent()
        val rest = arrayListOf<Calendar>()

        rest.add(n.t(2022, 0, 11))
        rest.add(n.t(2022, 0, 12))
        rest.add(n.t(2022, 0, 13))
        rest.add(n.t(2022, 1, 14))
        rest.add(n.t(2022, 1, 15))
        rest.add(n.t(2022, 1, 16))
        rest.add(n.t(2022, 1, 17))

        rest.add(n.t(2022, 2, 18))
        rest.add(n.t(2022, 2, 19))
        rest.add(n.t(2022, 2, 20))

        rest.add(n.t(2022, 3, 18))
        rest.add(n.t(2022, 3, 19))
        rest.add(n.t(2022, 3, 20))

        rest.add(n.t(2022, 4, 18))
        rest.add(n.t(2022, 4, 19))
        rest.add(n.t(2022, 4, 20))

        rest.add(n.t(2022, 5, 18))
        rest.add(n.t(2022, 5, 19))
        rest.add(n.t(2022, 5, 20))

        rest.add(n.t(2022, 6, 18))
        rest.add(n.t(2022, 6, 19))
        rest.add(n.t(2022, 6, 20))

        rest.add(n.t(2022, 7, 18))
        rest.add(n.t(2022, 7, 19))
        rest.add(n.t(2022, 7, 20))

        rest.add(n.t(2022, 8, 18))
        rest.add(n.t(2022, 8, 19))
        rest.add(n.t(2022, 8, 20))

        rest.add(n.t(2022, 9, 18))
        rest.add(n.t(2022, 9, 19))
        rest.add(n.t(2022, 9, 20))

        rest.add(n.t(2022, 10, 18))
        rest.add(n.t(2022, 10, 19))
        rest.add(n.t(2022, 10, 20))

        rest.add(n.t(2022, 11, 18))
        rest.add(n.t(2022, 11, 19))
        rest.add(n.t(2022, 11, 20))

        rest.add(n.t(2022, 12, 18))
        rest.add(n.t(2022, 12, 19))
        rest.add(n.t(2022, 12, 20))

        val events: ArrayList<EventDay> = ArrayList()

        for (i in rest)
            events.add(EventDay(i, R.drawable.new_resource))


        calender.setEvents(events)

        val z = ArrayList<CalendarDataModelClass>()
        when (t) {

            0 -> {
                z.add(CalendarDataModelClass("Holi", dateFormat(rest.get(0))))
                z.add(CalendarDataModelClass("DiwaYearli", dateFormat(rest.get(1))))
                z.add(CalendarDataModelClass("BhaiDooj", dateFormat(rest.get(2))))

            }
            1 -> {
                z.add(CalendarDataModelClass("Holi", dateFormat(rest.get(3))))
                z.add(CalendarDataModelClass("Holi1", dateFormat(rest.get(4))))
                z.add(CalendarDataModelClass("BhaiDooj1", dateFormat(rest.get(5))))

            }
            2 -> {
                z.add(CalendarDataModelClass("Holi2", dateFormat(rest.get(7))))
                z.add(CalendarDataModelClass("DiwaYearli2", dateFormat(rest.get(8))))
                z.add(CalendarDataModelClass("BhaiDooj3", dateFormat(rest.get(9))))

            }
            3 -> {
                z.add(CalendarDataModelClass("Holi2", dateFormat(rest.get(10))))
                z.add(CalendarDataModelClass("DiwaYearli2", dateFormat(rest.get(11))))
                z.add(CalendarDataModelClass("BhaiDooj3", dateFormat(rest.get(12))))

            }
            4 -> {
                z.add(CalendarDataModelClass("Holi2", dateFormat(rest.get(13))))
                z.add(CalendarDataModelClass("DiwaYearli2", dateFormat(rest.get(14))))
                z.add(CalendarDataModelClass("BhaiDooj3", dateFormat(rest.get(15))))

            }
            5 -> {
                z.add(CalendarDataModelClass("Holi2", dateFormat(rest.get(16))))
                z.add(CalendarDataModelClass("DiwaYearli2", dateFormat(rest.get(17))))
                z.add(CalendarDataModelClass("BhaiDooj3", dateFormat(rest.get(18))))

            }
            6 -> {
                z.add(CalendarDataModelClass("Holi2", dateFormat(rest.get(19))))
                z.add(CalendarDataModelClass("DiwaYearli2", dateFormat(rest.get(20))))
                z.add(CalendarDataModelClass("BhaiDooj3", dateFormat(rest.get(21))))

            }
            7 -> {
                z.add(CalendarDataModelClass("Holi2", dateFormat(rest.get(22))))
                z.add(CalendarDataModelClass("DiwaYearli2", dateFormat(rest.get(23))))
                z.add(CalendarDataModelClass("BhaiDooj3", dateFormat(rest.get(24))))

            }
            8 -> {
                z.add(CalendarDataModelClass("Holi2", dateFormat(rest.get(25))))
                z.add(CalendarDataModelClass("DiwaYearli2", dateFormat(rest.get(26))))
                z.add(CalendarDataModelClass("BhaiDooj3", dateFormat(rest.get(27))))

            }
            9 -> {
                z.add(CalendarDataModelClass("Holi2", dateFormat(rest.get(28))))
                z.add(CalendarDataModelClass("DiwaYearli2", dateFormat(rest.get(29))))
                z.add(CalendarDataModelClass("BhaiDooj3", dateFormat(rest.get(30))))

            }
            10 -> {
                z.add(CalendarDataModelClass("Holi2", dateFormat(rest.get(31))))
                z.add(CalendarDataModelClass("DiwaYearli2", dateFormat(rest.get(32))))
                z.add(CalendarDataModelClass("BhaiDooj3", dateFormat(rest.get(33))))

            }
            11 -> {
                z.add(CalendarDataModelClass("Holi2", dateFormat(rest.get(34))))
                z.add(CalendarDataModelClass("DiwaYearli2", dateFormat(rest.get(35))))
                z.add(CalendarDataModelClass("BhaiDooj3", dateFormat(rest.get(36))))

            }
            12 -> {
                z.add(CalendarDataModelClass("Holi2", dateFormat(rest.get(37))))
                z.add(CalendarDataModelClass("DiwaYearli2", dateFormat(rest.get(38))))
                z.add(CalendarDataModelClass("BhaiDooj3", dateFormat(rest.get(39))))

            }


        }


        val adap = CalendarAdapter(this, z)
        recyclerView.adapter = adap

        return t
    }
}
