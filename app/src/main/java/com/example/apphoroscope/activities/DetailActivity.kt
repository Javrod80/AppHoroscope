package com.example.apphoroscope.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apphoroscope.R
import com.example.apphoroscope.data.Horoscope
import com.example.apphoroscope.data.HoroscopeCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private var horoscopeId: String? = null
    private lateinit var horoscope:Horoscope

    private lateinit var horoscopeTextView: TextView

    private lateinit var horoscopeDetailView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //horoscopeTextView = findViewById(R.id.horoscopeTextView)
        //horoscopeDetailView = findViewById(R.id.horoscopeDetailView)

        horoscopeId= intent.getStringExtra("HOROSCOPE_ID")
        horoscope = HoroscopeCall().getHoroscope(horoscopeId!!)


        getHoroscopeDaily()
    }

    private fun getHoroscopeDaily() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = HoroscopeCall().getHoroscopeDaily(horoscopeId!!)
            runOnUiThread {
                horoscopeDetailView.text = result

            }
        }

    }

}


