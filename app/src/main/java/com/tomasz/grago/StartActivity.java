package com.tomasz.grago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    //klasa uruchamiająca całą aplikacje

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onEasy(View view) {
        MainActivity.dimension = 9;
        MainActivity.pointCzarny = 0;
        MainActivity.pointBialy = 0;
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onMedium(View view) {
        MainActivity.dimension = 13;
        MainActivity.pointCzarny = 0;
        MainActivity.pointBialy = 0;
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onHard(View view) {
        MainActivity.dimension = 19;
        MainActivity.pointCzarny = 0;
        MainActivity.pointBialy = 0;
        startActivity(new Intent(this, MainActivity.class));
    }
}
