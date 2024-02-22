package com.example.apphoroscope.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apphoroscope.R
import com.example.apphoroscope.data.Horoscope
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LauncherActivity : AppCompatActivity() {


    private lateinit var boton1 : FloatingActionButton
    lateinit var editText : EditText
    val userId: EditText = editText
    val userPassword : EditText = editText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        boton1 = findViewById(R.id.Boton1)
        editText=findViewById(R.id.inUserId)
        editText=findViewById(R.id.inPassword)



        listerer()


    }

    private fun listerer() {

        boton1.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }









}