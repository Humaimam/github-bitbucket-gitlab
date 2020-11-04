package com.example.joyeco;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class preferenceUtils {
    public preferenceUtils(){

    }
    public static boolean SaveToken(String token, Context context){
        return save(token,"token",context);
    }
    public static String getToken(Context context){

        return get("token",context);
    }
    public static boolean save(String value, String constant, Context context){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(constant,value);
        editor.apply();
        return true;
    }

    public static String get(String value, Context context){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(value,null);
    }

}
