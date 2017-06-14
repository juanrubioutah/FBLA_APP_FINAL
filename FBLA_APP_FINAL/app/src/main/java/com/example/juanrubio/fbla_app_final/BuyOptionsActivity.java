package com.example.juanrubio.fbla_app_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BuyOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_options);
    }
    public void search(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
    public void featured(View view){
        Intent intent = new Intent(this, FeaturedItemsActivity.class);
        startActivity(intent);
    }
    public void back(View view){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
