package com.gshoaib998.airquality;

import android.content.Context;
import android.content.SharedPreferences;

public class CityRepository {
    public final SharedPreferences preferences;
    public static final String PREF_NAME="app_prefs";
    public static final String KEY_CITY="city";
    public CityRepository(Context context){
        preferences= context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
    }
    public String getLastCity(){
        return preferences.getString(KEY_CITY,"");
    }
    public void saveCity(String city){
        preferences.edit().putString(KEY_CITY,city).apply();
    }

}
