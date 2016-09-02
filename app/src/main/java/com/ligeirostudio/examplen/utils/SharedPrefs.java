package com.ligeirostudio.examplen.utils;

/**
 * Created by fernando.c.moreira on 01/09/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;



/**
 * Created by fernando.c.moreira on 01/09/2016.
 */
public class SharedPrefs {

    public static final String PREF_ID = "preferencias";


    public static void setString(Context context, String flag, String valor) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(flag, valor);
        editor.commit();
    }

    public static String getString(Context context, String flag) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        String s = pref.getString(flag, "");
        return s;
    }
}

