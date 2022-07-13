package com.cv5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cv5.mylibraies.BuildConfig;
import com.cv5.mylibraies.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MainActivity2 mainActivity2 = new MainActivity2();


        new mustUpdateScreen(this, mainActivity2, "https://configuraciomaxplayer.blogspot.com/2022/07/configuracion-todas-las-app.html",BuildConfig.VERSION_CODE).execute();
    }
}