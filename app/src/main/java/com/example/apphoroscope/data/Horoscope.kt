package com.example.apphoroscope.data

import com.example.apphoroscope.R

sealed class Horoscope (val image : Int , val name : Int) {

    object Aries : Horoscope (R.drawable.aries_icon, R.string.horoscope_name_aries)
}