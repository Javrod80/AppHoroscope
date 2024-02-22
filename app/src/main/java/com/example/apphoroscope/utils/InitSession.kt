package com.example.apphoroscope.utils

import android.content.Context
import android.content.SharedPreferences
import android.widget.EditText

class InitSession {

    val userId : EditText = userId
    val userPassword : EditText = userPassword
    var sharedPreferences :SharedPreferences? = null

    fun getPreference (context: Context, name:String){


        sharedPreferences = context.getSharedPreferences(name,Context.MODE_PRIVATE)

         fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
            val editMe = edit()
            operation(editMe)
            editMe.apply()
        }

        var SharedPreferences.userId
        get() = getInt(userId, 0)
        set(value) {
            editMe {
                it.putInt(userId, value)
            }
        }

        var SharedPreferences.password
        get() = getString(userPassword, "")
        set(value) {
            editMe {
                it.putString(userPassword, value)
            }
        }


    }

}








    }










}