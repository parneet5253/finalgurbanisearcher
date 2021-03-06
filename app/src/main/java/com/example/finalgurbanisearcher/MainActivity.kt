package com.example.finalgurbanisearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val data = ArrayList<ItemsViewModel>()

        data.add(ItemsViewModel(R.drawable.ggs_i, "Sri Guru Granth Sahib Ji ","lorem lpsum,sometimes reffered to as the placeholder text used in design "))
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

        // This will pass the ArrayList to our Adapter

        // Setting the Adapter with the recyclerview

        val firstFragment = Home(data)
//        val secondFragment = HukamNama()
//        val thirdFragment = RestoreData()
//        val fourthFragment = BackupData()
//        val fifthFragment = ShabadKosh()



        setCurrentFragment(firstFragment)

        val bottomMenuBar:BottomNavigationView? = findViewById<BottomNavigationView>(R.id.bottomMenuBar)
        bottomMenuBar?.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.home -> setCurrentFragment(firstFragment)
                R.id.hukamnama -> {
                    val i = Intent(this@MainActivity,HukamNama::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.restoreData -> {
                    val i = Intent(this@MainActivity,RestoreData::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.backData -> {
                    val i = Intent(this@MainActivity,BackupData::class.java)
                    startActivity(i)
                    finish()
                }
                R.id.shabadkosh -> {
                    val i = Intent(this@MainActivity,ShabadKosh::class.java)
                    startActivity(i)
                    finish()
                }

            }
            true
        }

    }
    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment)
            commit()
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
             R.id.setting->{
                 val i = Intent(this@MainActivity,setting::class.java)
                 startActivity(i)
            }


        }
    return true
    }
}