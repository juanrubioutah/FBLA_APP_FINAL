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

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class FeaturedItemsActivity extends AppCompatActivity {

    Item[] items;
    Context context;
    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        items = MainActivity.getGlobalItemManager().getAllItems();

        setContentView(R.layout.activity_featured_items);
        gridLayout = (GridLayout)findViewById(R.id.featuredItemsGridView);
        initGridView();

    }
    public void initGridView(){ //TODO: check if this works
        int currentRow = 0;
        int currentCol = 0;
        for(int i = 0; i<items.length; i++){
            final int index = i;
            Button button = new Button(context);
            BitmapDrawable bd = new BitmapDrawable(context.getResources(), items[i].getImage());
            button.setBackground(bd);
            if(currentRow>4){
                currentRow = 0;
                currentCol++;
            }
            ActionBar.LayoutParams params = new ActionBar.LayoutParams(currentRow, currentCol);
            button.setLayoutParams(params);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ItemInformationActivity.class);
                    intent.putExtra("itemIndex", index);
                    startActivity(intent);
                }
            });
            gridLayout.addView(button);
        }
    }
}
