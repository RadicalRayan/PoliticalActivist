package com.radicalmedia.politicalactivist;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    android.support.v7.app.ActionBar ab;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // list view set up
        listView = (ListView) findViewById(R.id.list_home);
        listView.setAdapter(new ListViewAdapter(this));
    }
}

class SingleItem {
    String title;
    String description;
    String date;
    SingleItem(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }
}

class ListViewAdapter extends BaseAdapter {

    ArrayList<SingleItem> list;
    Context context;
    ListViewAdapter(Context c) {
        list = new ArrayList<SingleItem>();
        context = c;

        Resources res = c.getResources();
        String[] titles = res.getStringArray(R.array.navOptions);
        String[] descriptions = res.getStringArray(R.array.navOptions);
        String[] date = res.getStringArray(R.array.navOptions);

        for (int i = 0; i < titles.length; i++) {
            list.add(new SingleItem(titles[i], descriptions[i], date[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row, viewGroup, false);
        TextView title = (TextView) row.findViewById(R.id.txtTitle);
        TextView description = (TextView) row.findViewById(R.id.txtDescription);
        TextView date = (TextView) row.findViewById(R.id.txtDate);

        SingleItem temp = list.get(i);
        title.setText(temp.title);
        date.setText(temp.date);
        description.setText(temp.description);
        return null;
    }
}