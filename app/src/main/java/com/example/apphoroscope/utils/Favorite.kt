package com.example.apphoroscope.utils

import android.content.Context
import android.content.SharedPreferences


class Favorite (context: Context) {

   private val SELECT_FAVORITE = "FAVORITE_SELECT"
   private var sharedPref : SharedPreferences

   init {
       sharedPref = context.getSharedPreferences(SELECT_FAVORITE,Context.MODE_PRIVATE)
   }


    fun setSelectFavorite (select:String) {
        val editor = sharedPref.edit()
        editor.putString (SELECT_FAVORITE,select)
        editor.apply()

    }

    fun getSelectFavorite (favorite: String): String? {
        return sharedPref.getString(SELECT_FAVORITE,null)


    }











}
















