package com.example.apphoroscope.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apphoroscope.R
import com.example.apphoroscope.adapters.HoroscopeAdapter
import com.example.apphoroscope.data.Horoscope
import com.example.apphoroscope.data.HoroscopeCall
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private val horoscopeList : List<Horoscope> = HoroscopeCall ().getHoroscopes()

    private lateinit var adapter: HoroscopeAdapter

    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initView()

        //getString(R.string.horoscope_name_aries)


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

    }




}



