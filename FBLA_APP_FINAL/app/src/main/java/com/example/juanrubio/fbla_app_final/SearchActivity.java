package com.example.juanrubio.fbla_app_final;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;

import java.util.HashMap;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class SearchActivity extends AppCompatActivity {

    EditText searchEditText;

    ListView listView;

    public static ItemManager manager = MainActivity.getGlobalItemManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchEditText = (EditText)findViewById(R.id.searchEditText);
        listView = (ListView)findViewById(R.id.searchListView);

    }
    public void search(View view){
        /*ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        progressBar.setIndeterminate(true);
        getListView().setEmptyView(progressBar);

        ViewGroup root = (ViewGroup)findViewById(android.R.id.content);
        root.addView(progressBar);*/

        String query = searchEditText.getText().toString();

        Item[] results = manager.searchItem(query);

        String[] names = new String[50]; //max search results of 50

        for(int i = 0; i<results.length; i++){
            names[i] = results[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);
    }
}



