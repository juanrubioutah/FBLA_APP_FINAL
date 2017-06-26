package com.example.juanrubio.fbla_app_final;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN) //TODO: find a better way to set the min api in project settings
public class MainActivity extends AppCompatActivity {

    public ImageView splashScreenImageView;
    public static ItemManager mainItemManager = new ItemManager();
    public static CartManager mainCartManager = new CartManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //set the splash screen's image view to have the correct image
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        splashScreenImageView = (ImageView) findViewById(R.id.splashscreen);
        splashScreenImageView.setImageResource(R.drawable.cardboardcat);
        mainItemManager.readItemsArray();
        int secondsDelayed = 2;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        }, secondsDelayed * 1000);
    }
    public static ItemManager getGlobalItemManager(){
        return mainItemManager;
    }
    public static CartManager getGlobalCartManager(){
        return mainCartManager;
    }
}
