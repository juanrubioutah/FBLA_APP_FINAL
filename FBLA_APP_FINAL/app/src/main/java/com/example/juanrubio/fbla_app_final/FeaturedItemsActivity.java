package com.example.juanrubio.fbla_app_final;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class FeaturedItemsActivity extends AppCompatActivity {

    ArrayList<Item> items;
    LinearLayout linearLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        items = MainActivity.getGlobalItemManager().getAllItems();

        setContentView(R.layout.activity_featured_items);
        linearLayout = (LinearLayout)findViewById(R.id.featuredItemsLayout);
        initLinearLayout();

    }
    public void initLinearLayout(){ //TODO: check if this works
       for(int i = 1; i<=items.size(); i++){
           final int index = i;
           LinearLayout itemLayout = new LinearLayout(this);
           itemLayout.setOrientation(LinearLayout.HORIZONTAL);

           ImageView itemImage = new ImageView(this);

           if(items.get(i).getImage()!=null){ //Assign the item's image to the image view if the item has one
               itemImage.setImageBitmap(items.get(i).getImage());
           }

           TextView itemTitle = new TextView(this);
           itemTitle.setText(items.get(i).getName());

           itemLayout.addView(itemImage);
           itemLayout.addView(itemTitle);

           itemLayout.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(context, ItemInformationActivity.class);
                   intent.putExtra("itemIndex", index);
                   startActivity(intent);
               }
           });
       }
    }
}