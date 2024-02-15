package com.example.apphoroscope.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apphoroscope.R
import com.example.apphoroscope.adapters.HoroscopeAdapter
import com.example.apphoroscope.data.Horoscope



class MainActivity : AppCompatActivity() {

    private var horoscopeList: List<Horoscope> = listOf(
        Horoscope.Aries,
        Horoscope.Taurus,
        Horoscope.Gemini,
        Horoscope.Cancer,
        Horoscope.Leo,
        Horoscope.Virgo,
        Horoscope.Libra,
        Horoscope.Scorpio,
        Horoscope.Sagittarius,
        Horoscope.Capricorn,
        Horoscope.Aquarius,
        Horoscope.Pisces
    )

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

            recyclerView.layoutManager = LinearLayoutManager(this)

            recyclerView.adapter = adapter


        }

    }

    private fun onItemClickListener(position: Int) {


        val horoscope: Horoscope = horoscopeList[position]

        val intent = Intent(this.applicationContext, DetailActivity::class.java)
        intent.putExtra("HOROSCOPE_NAME", getString(horoscope.name))
        startActivity(intent)

    }


}



