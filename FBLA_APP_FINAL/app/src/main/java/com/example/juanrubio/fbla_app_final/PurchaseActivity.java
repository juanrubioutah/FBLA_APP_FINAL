package com.example.juanrubio.fbla_app_final;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class PurchaseActivity extends AppCompatActivity {

    ScrollView scrollView;

    CartManager manager = MainActivity.getGlobalCartManager();

    public int totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        scrollView = (ScrollView)findViewById(R.id.purchaseScrollView);

        ArrayList<Item> cart = new ArrayList<Item>();
        cart = manager.getCart();

        for(int i = 0; i<cart.size(); i++){
            TextView nameTextView = new TextView(this);
            TextView priceTextView = new TextView(this);
            LinearLayout layout = new LinearLayout(this);
            nameTextView.setText(cart.get(i).getName());
            priceTextView.setText(cart.get(i).getPrice());
            int price = Integer.parseInt(cart.get(i).getPrice());
            totalPrice = totalPrice + price; //This is the key line here. adds the current item's price to the total price
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.addView(nameTextView);
            layout.addView(priceTextView);
            scrollView.addView(layout);
        }
        TextView totalPriceTextView = new TextView(this);
        totalPriceTextView.setText("GRAND TOTAL: "+totalPrice);


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
