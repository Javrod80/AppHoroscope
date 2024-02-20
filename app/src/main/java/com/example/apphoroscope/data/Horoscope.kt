package com.example.apphoroscope.data

import com.example.apphoroscope.R


 open class Horoscope(val image: Int, val name: Int, val id: String) {


    object Aries : Horoscope (R.drawable.aries_icon,R.string.horoscope_name_aries,"aries")
    object Taurus : Horoscope(R.drawable.taurus_tauro, R.string.horoscope_name_taurus,"tauro")
    object Gemini : Horoscope(R.drawable.gemini_icon, R.string.horoscope_name_gemini,"gemini")
    object Cancer : Horoscope(R.drawable.cancer_zodiac_icon, R.string.horoscope_name_cancer,"cancer")
    object Leo : Horoscope(R.drawable.leo_icon, R.string.horoscope_name_leo,"leo")
    object Virgo : Horoscope(R.drawable.virgo_icon, R.string.horoscope_name_virgo,"virgo")
    object Libra : Horoscope(R.drawable.libra_icon, R.string.horoscope_name_libra,"libra")
    object Scorpio : Horoscope(R.drawable.scorpius_icon, R.string.horoscope_name_scorpio,"scorpio")
    object Sagittarius : Horoscope(R.drawable.sagittarius_icon, R.string.horoscope_name_sagittarius,"sagittarius")
    object Capricorn : Horoscope(R.drawable.capricornius_icon, R.string.horoscope_name_capriconr,"capricorn")
    object Aquarius : Horoscope(R.drawable.aquarius_icon, R.string.horoscope_name_aquarius,"aquarius")
    object Pisces : Horoscope(R.drawable.pisces_symbol__heavy_blue_, R.string.horoscope_name_piesces,"pisces")

}

