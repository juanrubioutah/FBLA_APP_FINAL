package com.example.juanrubio.fbla_app_final;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class MainMenuActivity extends AppCompatActivity {

    ImageButton donateBtton;
    ImageButton buyButton;
    ItemManager myManager = MainActivity.getGlobalItemManager();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void buy(View view){
        Intent intent = new Intent(this, FeaturedItemsActivity.class);
        startActivity(intent);
    }
    public void donate(View view){
        Intent intent = new Intent(this, ItemDonationActivity.class);
        startActivity(intent);
    }

}
