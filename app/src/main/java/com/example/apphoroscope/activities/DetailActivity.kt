package com.example.apphoroscope.activities


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apphoroscope.R
import com.example.apphoroscope.R.id.menu_search
import com.example.apphoroscope.data.Horoscope
import com.example.apphoroscope.data.HoroscopeCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {


    private var horoscopeId: String? = null
    private lateinit var horoscope: Horoscope

    private lateinit var horoscopeImageView: ImageView
    private lateinit var horoscopeTextView: TextView
    private lateinit var horoscopeDatetextView: TextView
    private lateinit var horoscopeDetailView: TextView
    private lateinit var searchView : MenuItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        horoscopeImageView = findViewById(R.id.horoscopeImageView)
        horoscopeTextView = findViewById(R.id.horoscopeTextView)
        horoscopeDetailView = findViewById(R.id.horoscopeDetailView)
        horoscopeDatetextView = findViewById(R.id.DateHoroscope)



        horoscopeId = intent.getStringExtra("HOROSCOPE_ID")
        horoscope = HoroscopeCall().getHoroscope(horoscopeId!!)


        //supportActionBar?.setDisplayShowTitleEnable(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        getHoroscopeDaily()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

               menuInflater.inflate(R.menu.first_menu, menu)
        searchView = findViewById(menu_search)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true

            }
        }

       // when (item.itemId) {
        //    android.R.id.menu_search -> {
                finish()
       //     }
      //  }
        return super.onOptionsItemSelected(item)
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


