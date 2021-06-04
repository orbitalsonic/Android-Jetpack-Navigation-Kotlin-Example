package com.zekab.androidjetpacknavigationexample

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object GeneralUtils {

    fun fromObjectToString(mObject: UserItem): String {
        return Gson().toJson(mObject)
    }

    fun fromStringToObject(mString: String): UserItem {
        val noteType = object : TypeToken<UserItem>() {}.type
        return Gson().fromJson(mString, noteType)
    }


    fun getUserData(mContext: Context):String{
        val sharedPreferences: SharedPreferences =mContext.getSharedPreferences("userDataPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString("userDataValue","")!!
    }

    fun setUserData(mContext: Context, mData:String){
        val sharedPreferences: SharedPreferences =mContext.getSharedPreferences("userDataPrefs", Context.MODE_PRIVATE)
        val sharedPreferencesEditor: SharedPreferences.Editor  = sharedPreferences.edit()
        sharedPreferencesEditor.putString("userDataValue",mData)
        sharedPreferencesEditor.apply()

    }

}