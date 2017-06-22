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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class ItemInformationActivity extends AppCompatActivity {

    ItemManager manager = MainActivity.getGlobalItemManager();
    CartManager cartManager = MainActivity.getGlobalCartManager();
    Item myItem;
    int myIndex;

    TextView titleTextView;
    ImageView imageView;
    TextView priceTextView;
    TextView conditionTextView;
    TextView descriptionTextView;

    LinearLayout itemInformationLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String s = getIntent().getStringExtra("ITEM_INDEX");
        int index = Integer.parseInt(s);
        myIndex = index;
        myItem = manager.getItem(myIndex);
        setContentView(R.layout.activity_item_information);

        itemInformationLayout = (LinearLayout)findViewById(R.id.itemInformationLayout);

        titleTextView = (TextView)findViewById(R.id.itemTitleTextView);
        imageView = (ImageView)findViewById(R.id.itemImageImageView);
        priceTextView = (TextView)findViewById(R.id.itemPriceTextView);
        conditionTextView = (TextView)findViewById(R.id.itemConditionTextView);
        descriptionTextView = (TextView)findViewById(R.id.itemDescriptionTextView);
        populate();
    }
    public void populate(){
        try {
            titleTextView.setText(myItem.getName());
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            imageView.setImageBitmap(myItem.getImage());
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            priceTextView.setText(myItem.getPrice());
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            conditionTextView.setText(myItem.getCondition());
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            descriptionTextView.setText(myItem.getDescription());
        }catch(Exception e){
            e.printStackTrace();
        }
        refreshComments();
    }
    public void refreshComments(){
        String[][] comments = myItem.getComments();
        for(int i = 0; i<1000; i++){
            if(comments[i][0]!=""){
                TextView nameTextView = new TextView(this);
                TextView commentTextView = new TextView(this);
                nameTextView.setText(comments[i][0]);
                commentTextView.setText(comments[i][1]);
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout.addView(nameTextView);
                linearLayout.addView(commentTextView);
                itemInformationLayout.addView(linearLayout);
            }
            else{
                return;
            }
        }
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
    public void comment(View view){
        Intent intent = new Intent(this, CommentActivity.class);
        intent.putExtra("ITEM_INDEX", myIndex);
        startActivity(intent);
    }
}
