package com.example.apphoroscope.activities


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.apphoroscope.R
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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        horoscopeImageView = findViewById(R.id.horoscopeImageView) // llamar
        horoscopeTextView = findViewById(R.id.horoscopeTextView)
        horoscopeDetailView = findViewById(R.id.horoscopeDetailView)
        horoscopeDatetextView = findViewById(R.id.DateHoroscope)



        horoscopeId = intent.getStringExtra("HOROSCOPE_ID")
        horoscope = HoroscopeCall().getHoroscope(horoscopeId!!)


        //supportActionBar?.setDisplayShowTitleEnable(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        horoscopeImageView.setImageResource(horoscope.image) // imagen inicia
        horoscopeDatetextView.text = getString(horoscope.date)// fechas
        horoscopeTextView.text = getString(horoscope.name) // nombre

        getHoroscopeDaily()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       // val inflater : MenuInflater = menuInflater

        menuInflater.inflate(R.menu.first_menu, menu)


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true

            }
           R.id.menu_search -> {
               finish()
               return  true
           }
       }
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

   private fun showErrorDialog (){

       val builder : AlertDialog.Builder = AlertDialog.Builder(this)
       builder
           .setTitle("Cerrar Aplicación")
           .setMessage("Esta seguro de que quiere salir de la aplicación?")
           .setCancelable(false)
           .setPositiveButton("salir"){_,_->finish()}
           .setNegativeButton("No"){dialog,_->dialog?.cancel()}

       val dialog : AlertDialog = builder.create()
       dialog.show()
   }


    }





