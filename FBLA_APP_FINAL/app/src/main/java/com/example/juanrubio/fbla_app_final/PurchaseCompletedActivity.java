package com.example.juanrubio.fbla_app_final;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class PurchaseCompletedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_completed);
    }
    public void returnToMenu(View view){
        Intent intent = new Intent(getBaseContext(),MainMenuActivity.class);
        startActivity(intent);
    }
}
