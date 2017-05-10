package com.example.juanrubio.fbla_app_final;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.io.Serializable;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class SearchActivity extends AppCompatActivity {

    EditText searchBox = (EditText)findViewById(R.id.searchBox);

    ItemManager itemManager = MainActivity.getGlobalItemManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
    public void search(){
        String query = searchBox.getText().toString();
        Item[] results = itemManager.searchItem(query);
        Intent intent = new Intent(this, SearchResultsActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAY", (Serializable)results);
        intent.putExtra("resultsArray", args);
        startActivity(intent);
    }
}
