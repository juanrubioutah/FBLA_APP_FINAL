package com.example.juanrubio.fbla_app_final;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class SearchBar extends AppCompatActivity {

    CustomAdapter adapter;

    ItemManager manager = MainActivity.getGlobalItemManager();

    TextView itemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);

        ListView lv = (ListView)findViewById(R.id.search_view);
        ArrayList<Item> arrayItem = new ArrayList<>();
        arrayItem = manager.getAllItems();

        adapter = new CustomAdapter(
                SearchBar.this,
                R.layout.single_row,
                arrayItem);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemName = (TextView)findViewById(R.id.item_name);
                String name = itemName.getText().toString();
                int itemId = manager.getItemId(name);
                String myItem = Integer.toString(itemId);
                Intent intent = new Intent(SearchBar.this, ItemInformationActivity.class);
                intent.putExtra("ITEM_INDEX", myItem);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search_view,menu);
        MenuItem item = menu.findItem(R.id.search_tray);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }
}
