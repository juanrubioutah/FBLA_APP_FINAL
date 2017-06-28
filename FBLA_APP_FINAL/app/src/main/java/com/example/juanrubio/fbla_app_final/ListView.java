package com.example.juanrubio.fbla_app_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;

import java.util.ArrayList;


public class ListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = (ListView)findViewById(R.id.list_view);
        ArrayList<Product> products = new ArrayList<Product>();


        //somehow get all the array info here

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),R.layout.single_row, )
    }
}
