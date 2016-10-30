package com.radicalmedia.politicalactivist;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MakeAccount extends AppCompatActivity {

    android.support.v7.app.ActionBar ab;
    EditText address;
    EditText email;
    EditText age;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_account);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.make_account_toolbar);
        myToolbar.setTitle("Register");
        myToolbar.setTitleTextAppearance(this, R.style.MyTitleTextAppearance);
        setSupportActionBar(myToolbar);

        final Context context = this;
        final Intent makeAccount = new Intent(context, Home.class);

        ab = getSupportActionBar();
        //ab.setHomeButtonEnabled(true);
        //ab.setDisplayHomeAsUpEnabled(true);
        //ab.setHomeAsUpIndicator(R.drawable.ic_action_draw_open);

        address = (EditText) findViewById(R.id.txtAddress);
        email = (EditText) findViewById(R.id.txtEmail);
        age = (EditText) findViewById(R.id.txtAge);
        register = (Button) findViewById(R.id.btnSub);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!address.getText().toString().equals("")) {
                    if (!age.getText().toString().equals("")) {
                        // Submit info to database and enter into phone
                        String filename = "userInfo";
                        String string = address.getText().toString() + "; " + email.getText().toString() + "; " + age.getText().toString();
                        FileOutputStream outputStream;

                        try {

                            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                            outputStream.write(string.getBytes());
                            outputStream.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        startNextActivity(context, makeAccount);
                    } else {
                        Toast.makeText(getApplicationContext(), "Please enter your age.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter your address.", Toast.LENGTH_SHORT).show();
                }
            }
        }); {

        }
    }

    private void startNextActivity(Context c, Intent makeAccount) {
        Toast.makeText(c, "Thank you for registering!", Toast.LENGTH_SHORT).show();
        startActivity(makeAccount);
    }
}
