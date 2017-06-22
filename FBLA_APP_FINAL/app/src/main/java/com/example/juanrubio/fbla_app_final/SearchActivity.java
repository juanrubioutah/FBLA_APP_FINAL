package com.example.juanrubio.fbla_app_final;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class SearchActivity extends AppCompatActivity {

    EditText searchBox;

    LinearLayout searchLayout;

    ItemManager itemManager = MainActivity.getGlobalItemManager();

    Item[] results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchBox = (EditText)findViewById(R.id.searchBox);
        searchLayout = (LinearLayout)findViewById(R.id.searchLayout);
    }
    public void search(View view){
        String query = searchBox.getText().toString();
        results = itemManager.searchItem(query);
        if(results!=null){
            displaySearchResults();
        }else{
            TextView textView = new TextView(this);
            textView.setText("No Items Matched Search Query");
        }
    }
    //displaySearchResults now appears in the search activity, under the search bar, instead of creating a new activity.
    public void displaySearchResults(){
        for(int i = 0; i<results.length; i++){
            if(!(results[i].getName().equals(""))) { //Make sure that results[i] has a valid name
                LinearLayout layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView = new ImageView(this);
                imageView.setImageBitmap(results[i].getImage());
                TextView textView = new TextView(this);
                textView.setText(results[i].getName());
                imageView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                layout.addView(textView);
                layout.addView(imageView);
                searchLayout.addView(layout);

            }
        }
    }
}
