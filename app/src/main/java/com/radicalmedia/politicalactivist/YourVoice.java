package com.radicalmedia.politicalactivist;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class YourVoice extends AppCompatActivity implements AdapterView.OnItemClickListener{
    android.support.v7.app.ActionBar ab;
    private ListView navListView;
    private String[] objs;
    private DrawerLayout drawerLayout;

    //Survey fields
    EditText txtFirst;
    CheckBox one;
    CheckBox two;
    CheckBox three;
    CheckBox four;
    CheckBox five;
    CheckBox six;
    CheckBox seven;
    CheckBox eight;
    CheckBox nine;
    EditText other1;
    EditText other2;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_voice);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navListView = (ListView) findViewById(R.id.left_drawer);
        objs = getResources().getStringArray(R.array.navOptions);
        navListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, objs));
        navListView.setOnItemClickListener(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.yourvoice_toolbar);
        myToolbar.setTitle("Your Voice");
        myToolbar.setTitleTextAppearance(this, R.style.MyTitleTextAppearance);
        setSupportActionBar(myToolbar);

        ab = getSupportActionBar();
        ab.setHomeButtonEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_action_draw_open);

        //Survey Text Boxes
        txtFirst = (EditText) findViewById(R.id.txtFirst);
        one = (CheckBox) findViewById(R.id.ck1);
        two = (CheckBox) findViewById(R.id.ck2);
        three = (CheckBox) findViewById(R.id.ck3);
        four = (CheckBox) findViewById(R.id.ck4);
        five = (CheckBox) findViewById(R.id.ck5);
        six = (CheckBox) findViewById(R.id.ck6);
        seven = (CheckBox) findViewById(R.id.ck7);
        eight = (CheckBox) findViewById(R.id.ck8);
        nine = (CheckBox) findViewById(R.id.ck9);
        other1 = (EditText) findViewById(R.id.txtIOther1 );
        other2 = (EditText) findViewById(R.id.txtOther2);
        but = (Button) findViewById(R.id.btnSub);

        four.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    other1.setVisibility(View.VISIBLE);
                } else if (!isChecked) {
                    other1.setVisibility(View.INVISIBLE);
                }
            }
        });

        nine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    other2.setVisibility(View.VISIBLE);
                } else if (!isChecked) {
                    other2.setVisibility(View.INVISIBLE);
                }
            }
        });

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (!one.isChecked() && !two.isChecked() && !three.isChecked() && !four.isChecked()) {
                        Toast.makeText(getApplicationContext(), "Please enter your previous communication", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!five.isChecked() && !six.isChecked() && !seven.isChecked() && !seven.isChecked() && !eight.isChecked() && !nine.isChecked()) {
                            Toast.makeText(getApplicationContext(), "Please enter the topic you most believe in", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Thanks for your input!", Toast.LENGTH_SHORT).show();

                            txtFirst.setText("");
                            one.setChecked(false);
                            two.setChecked(false);
                            three.setChecked(false);
                            four.setChecked(false);
                            five.setChecked(false);
                            six.setChecked(false);
                            seven.setChecked(false);
                            eight.setChecked(false);
                            nine.setChecked(false);
                            other1.setText("");
                            other2.setText("");
                        }
                    }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0) {
            Intent transfer = new Intent(this, Home.class);
            startActivity(transfer);
        } else if (position == 1) {
            Intent transfer = new Intent(this, ContactCongress.class);
            startActivity(transfer);
        } else if (position == 2) {
            Intent transfer = new Intent(this, YourVoice.class);
            startActivity(transfer);
        } else if (position == 3) {
            Intent transfer = new Intent(this, LearnMore.class);
            startActivity(transfer);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();
        if (res_id == 16908332) {
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(Gravity.LEFT);
        }

        return true;
    }
}
