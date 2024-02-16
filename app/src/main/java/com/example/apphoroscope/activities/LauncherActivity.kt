package com.example.apphoroscope.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apphoroscope.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LauncherActivity : AppCompatActivity() {


    private val boton1 : FloatingActionButton = findViewById(R.id.Boton1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)



        listerer()

    }

    private fun listerer() {

        boton1.setOnClickListener() {

        }
        val intent = Intent(this, LauncherActivity::class.java)
        startActivity(intent)


    }
}