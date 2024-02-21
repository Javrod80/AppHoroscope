package com.example.apphoroscope.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apphoroscope.R
import com.example.apphoroscope.data.Horoscope
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LauncherActivity : AppCompatActivity() {


    private lateinit var boton1 : FloatingActionButton
    private lateinit var horoscopeTextView: TextView
    private lateinit var horoscopedatehoroscope: TextView
    private lateinit var horoscopeDetailView :TextView
    private lateinit var horoscope: Horoscope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        boton1 = findViewById(R.id.Boton1)



        listerer()


    }

    private fun listerer() {

        boton1.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}