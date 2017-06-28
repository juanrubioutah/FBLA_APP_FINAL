package com.example.juanrubio.fbla_app_final;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class ListView extends AppCompatActivity {

    ItemManager itemManager = MainActivity.getGlobalItemManager();
    CartManager cartManager = MainActivity.getGlobalCartManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
<<<<<<< HEAD
        ///ListView listView = (ListView)findViewById(R.id.list_view);
=======
        android.widget.ListView listView = (android.widget.ListView)findViewById(R.id.list_view);
>>>>>>> origin/master
        ArrayList<Product> products = new ArrayList<Product>();


        //somehow get all the array info here
<<<<<<< HEAD

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),R.layout.single_row, products);
        //ListView.setAdapter(adapter);
=======
        String[] itemNames = itemManager.getAllItemNames();
        String[] cartNames = cartManager.getItemNames();
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),R.layout.single_row, );
>>>>>>> origin/master
    }
}
