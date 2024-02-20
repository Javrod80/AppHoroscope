package com.example.apphoroscope.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apphoroscope.R
import com.example.apphoroscope.adapters.HoroscopeAdapter
import com.example.apphoroscope.data.Horoscope
import com.example.apphoroscope.data.HoroscopeCall


class MainActivity : AppCompatActivity() {
    private var horoscopeList : List<Horoscope> = HoroscopeCall ().getHoroscopes()

    private lateinit var adapter: HoroscopeAdapter

    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initView()

        getString(R.string.horoscope_name_aries)


    }

    private fun initView() {
        recyclerView = findViewById(R.id.horoscopeList)

        adapter = HoroscopeAdapter(horoscopeList) {
            onItemClickListener(it)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

    }

    private fun onItemClickListener(position: Int) {


        val horoscope: Horoscope = horoscopeList[position]

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("HOROSCOPE_ID", horoscope.id)
        startActivity(intent)
        //Toast.makeText(this, getString(horoscope.name), Toast.LENGTH_LONG).show()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.horoscope_menu, menu)

        initSearchView(menu?.findItem(R.id.menu_search))

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initSearchView(searchItem: MenuItem?) {
        if (searchItem != null) {
            var searchView = searchItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    if (query.isNullOrEmpty()) {
                        horoscopeList = HoroscopeCall().getHoroscopes()
                    } else {
                        horoscopeList = HoroscopeCall().getHoroscopes()
                            .filter { getString(it.name).contains(query, true) }
                    }
                    adapter.updateData(horoscopeList)
                    return true
                }
            })
        }
    }
}




