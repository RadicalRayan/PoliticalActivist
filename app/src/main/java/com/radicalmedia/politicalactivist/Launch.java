package com.radicalmedia.politicalactivist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Launch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Boolean isFirstRun = getSharedPreferences("com.radicalmedia.politicalactivist", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun) {
            getSharedPreferences("com.radicalmedia.politicalactivist", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).apply();
            Intent makeAccount = new Intent(this, MakeAccount.class);
            startActivity(makeAccount);
        } else {
            Intent goHome = new Intent(this, Home.class);
            startActivity(goHome);
        }
    }
}
