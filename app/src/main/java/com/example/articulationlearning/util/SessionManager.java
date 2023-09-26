package com.example.articulationlearning.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    static final String KEY_LOGIN =
            "login",
            KEY_ID = "id",
            KEY_NAME = "name",
            KEY_NUMBER = "number";

    public static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(
                "learning", Context.MODE_PRIVATE);
    }

    public static void setCustData(Context context, String name, String custNumber, int id) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(KEY_LOGIN, true);
        editor.putInt(KEY_ID, id);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_NUMBER, custNumber);
        editor.apply();
    }


    public static int getId(Context context) {
        return getSharedPreference(context).getInt(KEY_ID, 0);
    }


    public static String getName(Context context) {
        return getSharedPreference(context).getString(KEY_NAME, "");
    }

    public static String getNumber(Context context) {
        return getSharedPreference(context).getString(KEY_NUMBER, "");
    }

    public static Boolean getIsLogin(Context context) {
        return getSharedPreference(context).getBoolean(KEY_LOGIN, false);
    }

    public static void clearData(Context context) {
        getSharedPreference(context).edit().clear().apply();
    }

}
