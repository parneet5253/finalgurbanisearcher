package com.example.finalgurbanisearcher

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalgurbanisearcher.CustomAdapter.OnNoteListener

class Home(private val mList: List<ItemsViewModel>) : Fragment(), OnNoteListener {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
val view = inflater.inflate(R.layout.home,container,false)

        val recyclerview = view.findViewById<RecyclerView?>(R.id.recyclerview)
val iteDecorator1= SimpleDividerItemDecoration(container!!.context,R.drawable.line_divider)


recyclerview?.addItemDecoration(iteDecorator1)
        recyclerview?.layoutManager = LinearLayoutManager(context)





        val data = ArrayList<ItemsViewModel>()


             data.add(ItemsViewModel(R.drawable.book3x, "Sri Guru Granth Sahib Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
             data.add(ItemsViewModel(R.drawable.sunder_gutka3x, "Sunder Gutka ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
             data.add(ItemsViewModel(R.drawable.kabit_bhai_gurdas_ji, "Kabit Bhai Gurdas Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
             data.add(ItemsViewModel(R.drawable.book3x, "Sri Dasham Granth Sahib Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
             data.add(ItemsViewModel(R.drawable.book3x, "Sri Guru Granth Sahib Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
             data.add(ItemsViewModel(R.drawable.book3x, "Sri Guru Granth Sahib Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
             data.add(ItemsViewModel(R.drawable.book3x, "Sri Guru Granth Sahib Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
             data.add(ItemsViewModel(R.drawable.book3x, "Sri Guru Granth Sahib Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
             data.add(ItemsViewModel(R.drawable.book3x, "Sri Guru Granth Sahib Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
            data.add(ItemsViewModel(R.drawable.book3x, "Sri Guru Granth Sahib Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
             data.add(ItemsViewModel(R.drawable.book3x, "Sri Guru Granth Sahib Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
             data.add(ItemsViewModel(R.drawable.book3x, "Sri Guru Granth Sahib Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))




        val adap = CustomAdapter(data,this )
        recyclerview?.adapter=adap

        val cardViewcompiledHymns = view.findViewById<CardView>(R.id.cardViewCompiledHymns)

        cardViewcompiledHymns.setOnClickListener{

            var intent = Intent(context,CompiledHymns::class.java)

            startActivity(intent)
        }

        val cardCalender = view.findViewById<CardView>(R.id.CardCalender)

        cardCalender.setOnClickListener{
            var intent = Intent(context,CalenderClass::class.java)

            startActivity(intent)
//            Toast.makeText(context,"calender Clicked",Toast.LENGTH_LONG).show()

        }
        val cardRadio = view.findViewById<CardView>(R.id.cardRadio)

        cardRadio.setOnClickListener{

//            Toast.makeText(context,"radio  Clicked",Toast.LENGTH_LONG).show()
        var intent = Intent(context,LiveKirtan::class.java)

            startActivity(intent)

        }
        val cardYouTube = view.findViewById<CardView>(R.id.CardYouTube)

        cardYouTube.setOnClickListener{

//            Toast.makeText(context,"YouTube Clicked",Toast.LENGTH_LONG).show()
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=tbtEbqrumD4/"))
                startActivity(intent)
        }


        return (view)
    }

    override fun onNoteClick(position: Int) {

mList.get(position)
       // Toast.makeText(context,"you Clicked $position ",Toast.LENGTH_SHORT).show()
    }
}