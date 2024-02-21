package com.example.apphoroscope.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.apphoroscope.R
import com.example.apphoroscope.adapters.HoroscopeAdapter
import com.example.apphoroscope.data.Horoscope
import com.example.apphoroscope.data.HoroscopeCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {


    private var horoscopeId: String? = null
    private lateinit var horoscope:Horoscope
    private var horoscopeList : List<Horoscope> = HoroscopeCall ().getHoroscopes()

    private lateinit var horoscopeTextView: TextView
    lateinit var horoscopeDatetextView: TextView
    lateinit var horoscopeAdapter: HoroscopeAdapter

    private lateinit var horoscopeDetailView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        horoscopeTextView = findViewById(R.id.horoscopeTextView)
        horoscopeDetailView = findViewById(R.id.horoscopeDetailView)
        horoscopeDatetextView = findViewById(R.id.horoscopeTextView)

        horoscopeId= intent.getStringExtra("HOROSCOPE_ID")
        horoscope = HoroscopeCall().getHoroscope(horoscopeId!!)


        getHoroscopeDaily()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.first_menu, menu)

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
                    horoscopeAdapter.updateData(horoscopeList)

                    return true
                }
            })
        }
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


