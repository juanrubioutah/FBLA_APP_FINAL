package com.example.juanrubio.fbla_app_final;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class CartActivity extends AppCompatActivity {

    CartManager cartManager = MainActivity.getGlobalCartManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }
}
