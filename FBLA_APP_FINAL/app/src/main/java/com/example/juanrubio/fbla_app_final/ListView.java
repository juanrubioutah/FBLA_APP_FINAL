package com.example.juanrubio.fbla_app_final;

import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class ListView extends AppCompatActivity {

    //ItemManager itemManager = MainActivity.getGlobalItemManager();
    //CartManager cartManager = MainActivity.getGlobalCartManager();
    ListView list;
    String[] titles;
    String[] prices;
    int[] imgs = {R.drawable.yellow_chair, R.drawable.purse, R.drawable.keyboard, R.drawable.coffee_maker,
            R.drawable.textbook, R.drawable.coat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Resources res = getResources();

        titles = res.getStringArray(R.array.itemArray);
        prices = res.getStringArray(R.array.priceArray);

        //list = (ListView)findViewById(R.id.list_view);

        android.widget.ListView listView = (android.widget.ListView)findViewById(R.id.list_view);

        ArrayList<Product> products = new ArrayList<Product>();



        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),R.layout.single_row, products);
        //ListView.setAdapter(adapter);

        //String[] itemNames = itemManager.getAllItemNames();
        //String[] cartNames = cartManager.getItemNames();
        
        //CustomAdapter adapter = new CustomAdapter(getApplicationContext(),R.layout.single_row, );
    }
}
