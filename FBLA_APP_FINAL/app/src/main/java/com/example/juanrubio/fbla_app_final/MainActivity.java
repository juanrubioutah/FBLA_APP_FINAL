package com.example.juanrubio.fbla_app_final;


import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN) //TODO: find a better way to set the min api in project settings
public class MainActivity extends AppCompatActivity {

    public ImageView splashScreenImageView;
    public static ItemManager mainItemManager = new ItemManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        splashScreenImageView = (ImageView) findViewById(R.id.splashScreenImageView);
        //set the splash screen's image view to have the correct image
        //TODO: FIXME: splashScreenImageView.setImageResource(R.drawable.IMAGE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        mainItemManager.readItemsArray();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
    public static ItemManager getGlobalItemManager(){
        return mainItemManager;
    }
}
