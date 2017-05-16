package com.example.juanrubio.fbla_app_final;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class SearchResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("resultsArray");
        Item[] results = (Item[])args.getSerializable("ARRAY");

        createSearchResults(results);

    }
    //Creates linearLayouts and views systematically to display search result results
    public void createSearchResults(Item[] results){ //TODO: check if this works
        for(int i = 0; i<results.length; i++){
           if(!(results[i].getName().equals(""))) { //Make sure that results[i] is a valid item
               LinearLayout layout = new LinearLayout(this);
               layout.setOrientation(LinearLayout.HORIZONTAL);
               ImageView imageView = new ImageView(this);
               imageView.setImageBitmap(results[i].getImage());
               TextView textView = new TextView(this);
               textView.setText(results[i].getName());
           }
        }
    }
}
