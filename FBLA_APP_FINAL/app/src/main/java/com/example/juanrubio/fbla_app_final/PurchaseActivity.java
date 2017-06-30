package com.example.juanrubio.fbla_app_final;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class PurchaseActivity extends AppCompatActivity {


    ScrollView scrollView;

    CartManager manager = MainActivity.getGlobalCartManager();
    int myIndex;

    TextView totalPriceTextView;

    public int totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);


        scrollView = (ScrollView)findViewById(R.id.purchaseScrollView);


        ArrayList<Item> cart = new ArrayList<Item>();
        cart = manager.getCart();
        //TODO: test this
        for(int i = 0; i<cart.size(); i++){
            TextView textView = new TextView(this);
            textView.setText(manager.getItem(i).getName()+"      $"+manager.getItem(i).getPrice());
            scrollView.addView(textView);
        }
        totalPriceTextView = (TextView)findViewById(R.id.totalPriceTextView);
        totalPriceTextView.setText("Grand Total: $"+manager.getTotalCost());

        Intent intent = getIntent();
        myIndex = intent.getIntExtra("itemIndex", 0);


    }
    public void pay(View view){
        manager.setTotalCost(totalPrice);
        Intent intent = new Intent(this, PaymentDetailsActivity.class);
        startActivity(intent);
    }
    public void cancel(View view){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
