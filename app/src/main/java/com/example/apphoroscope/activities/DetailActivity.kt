package com.example.apphoroscope.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apphoroscope.R
import com.example.apphoroscope.data.HoroscopeCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private var horoscopeName: String? = null


    private lateinit var horoscopeTextView: TextView

    private lateinit var horoscopeDetailView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        horoscopeTextView = findViewById(R.id.horoscopeTextView)
        horoscopeDetailView = findViewById(R.id.horoscopeDetailView)

        horoscopeName= intent.getStringExtra("HOROSCOPE_NAME")


        horoscopeTextView.text = horoscopeName

        getHoroscopeDaily()
    }

    private fun getHoroscopeDaily() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = HoroscopeCall().getHoroscopeDaily(horoscopeName!!)
            runOnUiThread {
                horoscopeDetailView.text = result

            }
        }

    }
}


