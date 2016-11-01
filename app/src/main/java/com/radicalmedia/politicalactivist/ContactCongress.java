package com.radicalmedia.politicalactivist;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactCongress extends AppCompatActivity  implements AdapterView.OnItemClickListener {

    android.support.v7.app.ActionBar ab;
    private ListView navListView;
    private String[] objs;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_congress);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navListView = (ListView) findViewById(R.id.left_drawer);
        objs = getResources().getStringArray(R.array.navOptions);
        navListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, objs));
        navListView.setOnItemClickListener(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.contactcongress_toolbar);
        myToolbar.setTitle("Contact Congress");
        myToolbar.setTitleTextAppearance(this, R.style.MyTitleTextAppearance);
        setSupportActionBar(myToolbar);

        ab = getSupportActionBar();
        ab.setHomeButtonEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_action_draw_open);


        // WebView setup
        String url = "http://www.house.gov/representatives/find/";
        WebView view = (WebView) this.findViewById(R.id.webView);
        view.setWebViewClient(new MyBrowser());
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setSupportZoom(true);
        view.loadUrl(url);

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

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}