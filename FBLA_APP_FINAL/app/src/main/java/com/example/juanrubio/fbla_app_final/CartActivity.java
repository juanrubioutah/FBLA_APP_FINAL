package com.example.juanrubio.fbla_app_final;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class CartActivity extends AppCompatActivity { //TODO: FENG: make a way for the user to actually be able to get into the CartActivity

    CartManager cartManager = MainActivity.getGlobalCartManager();

    LinearLayout cartLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cartLayout = (LinearLayout)findViewById(R.id.cartLinearLayout);
        initCart();
    }
    public void initCart(){
        if(cartManager.getCart().size()>0){ //If the cart contains at least one item
            for(int i = 1; i<=cartManager.getCart().size(); i++){
                final int index = i-1;
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                ImageView imageView = new ImageView(this);
                imageView.setImageBitmap(cartManager.getItem(index).getImage());

                TextView textView = new TextView(this);
                textView.setText(cartManager.getItem(index).getName());

                linearLayout.addView(imageView);
                linearLayout.addView(textView);
            }
        }
        else{
            TextView textView = new TextView(this);
            textView.setText("There are no items in the cart");
            cartLayout.addView(textView);
        }
    }
}
