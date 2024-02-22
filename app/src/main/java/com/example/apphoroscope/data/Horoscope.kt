package com.example.apphoroscope.data

import com.example.apphoroscope.R


sealed class Horoscope(val image: Int, val name: Int, val id: String, val date :Int) {


    object Aries : Horoscope (R.drawable.aries_icon,R.string.horoscope_name_aries,"aries",R.string.horoscope_date_aries)
    object Taurus : Horoscope(R.drawable.taurus_tauro, R.string.horoscope_name_taurus,"tauro",R.string.horoscope_date_taurus)
    object Gemini : Horoscope(R.drawable.gemini_icon, R.string.horoscope_name_gemini,"gemini",R.string.horoscope_date_gemini)
    object Cancer : Horoscope(R.drawable.cancer_zodiac_icon, R.string.horoscope_name_cancer,"cancer",R.string.horoscope_date_cancer)
    object Leo : Horoscope(R.drawable.leo_icon, R.string.horoscope_name_leo,"leo",R.string.horoscope_date_leo)
    object Virgo : Horoscope(R.drawable.virgo_icon, R.string.horoscope_name_virgo,"virgo",R.string.horoscope_date_virgo)
    object Libra : Horoscope(R.drawable.libra_icon, R.string.horoscope_name_libra,"libra",R.string.horoscope_date_libra)
    object Scorpio : Horoscope(R.drawable.scorpius_icon, R.string.horoscope_name_scorpio,"scorpio",R.string.horoscope_date_scorpio)
    object Sagittarius : Horoscope(R.drawable.sagittarius_icon, R.string.horoscope_name_sagittarius,"sagittarius",R.string.horoscope_date_sagittarius)
    object Capricorn : Horoscope(R.drawable.capricornius_icon, R.string.horoscope_name_capriconr,"capricorn",R.string.horoscope_date_capriconr)
    object Aquarius : Horoscope(R.drawable.aquarius_icon, R.string.horoscope_name_aquarius,"aquarius",R.string.horoscope_date_aquarius)
    object Pisces : Horoscope(R.drawable.pisces_symbol__heavy_blue_, R.string.horoscope_name_piesces,"pisces",R.string.horoscope_date_piesces)


}

