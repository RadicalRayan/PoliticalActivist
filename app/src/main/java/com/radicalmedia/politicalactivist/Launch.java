package com.radicalmedia.politicalactivist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Launch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun) {
            Intent makeAccount = new Intent(this, MakeAccount.class);
            startActivity(makeAccount);
        } else {
            Intent makeAccount = new Intent(this, Home.class);
            startActivity(makeAccount);
        }
    }
}
