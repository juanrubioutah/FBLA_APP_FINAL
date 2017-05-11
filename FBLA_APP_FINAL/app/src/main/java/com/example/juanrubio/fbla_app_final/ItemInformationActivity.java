package com.example.juanrubio.fbla_app_final;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class ItemInformationActivity extends AppCompatActivity {

    ItemManager manager = MainActivity.getGlobalItemManager();
    CartManager cartManager = MainActivity.getGlobalCartManager();
    Item myItem;
    int myIndex;

    TextView titleTextView = (TextView)findViewById(R.id.itemTitleTextView);
    ImageView imageView = (ImageView)findViewById(R.id.itemImageImageView);
    TextView priceTextView = (TextView)findViewById(R.id.itemPriceTextView);
    TextView conditionTextView = (TextView)findViewById(R.id.itemConditionTextView);
    TextView descriptionTextView = (TextView)findViewById(R.id.itemDescriptionTextView);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        myIndex = intent.getIntExtra("itemIndex", 0);
        myItem = manager.getItem(myIndex);
        setContentView(R.layout.activity_item_information);
        populate();
    }
    public void populate(){
        titleTextView.setText(myItem.getName());
        imageView.setImageBitmap(myItem.getImage());
        priceTextView.setText(myItem.getPrice());
        conditionTextView.setText(myItem.getCondition());
        descriptionTextView.setText(myItem.getDescription());
    }
    public void addToCart(View view){
        cartManager.addItem(myItem);
        //Show a toast notification telling the user the item has been added to the cart
        Toast toast = Toast.makeText(this, "Item Successfully Added To Cart", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void cancel(View view){
        Intent intent = new Intent(this, FeaturedItemsActivity.class);
        startActivity(intent);
    }
}
