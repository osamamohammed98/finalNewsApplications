package com.osama.finalnewsapplications;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

public class Prefernces extends AppCompatActivity {

    SharedPreferences.Editor editor = getSharedPreferences("is_fav" , 0).edit();
    SharedPreferences preferences = getSharedPreferences("is_fav" , 0);

    boolean isfavs = preferences.getBoolean("is_fav" , true);

    public  void check() {

        if (isfavs) {

        }
    }
}
