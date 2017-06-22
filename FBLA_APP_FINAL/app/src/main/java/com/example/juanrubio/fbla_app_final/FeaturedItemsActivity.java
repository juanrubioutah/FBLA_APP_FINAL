package com.example.juanrubio.fbla_app_final;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
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
    public void initLinearLayout() { //TODO: check if this works
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                final int index = i;
                LinearLayout itemLayout = new LinearLayout(this);
                itemLayout.setOrientation(LinearLayout.HORIZONTAL);

                ImageView itemImage = new ImageView(this);

                try {
                    itemImage.setImageBitmap(items.get(i).getImage());
                }catch(Exception e){
                    e.printStackTrace();
                }

                TextView itemTitle = new TextView(this);
                try{
                    itemTitle.setText(items.get(i).getName());
                }catch(Exception e){
                    e.printStackTrace();
                }

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
        else{ //If there are no items in the array, display a text view telling the user there are currently no items available
            TextView textView = new TextView(this);
            textView.setText("There are currently no items\navailable to purchase");
            linearLayout.setGravity(LinearLayout.TEXT_ALIGNMENT_GRAVITY);
            linearLayout.addView(textView);
        }
    }
}
