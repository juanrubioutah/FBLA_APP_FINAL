package com.example.juanrubio.fbla_app_final;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class CommentActivity extends AppCompatActivity {
    ItemManager itemManager = MainActivity.getGlobalItemManager();
    Item myItem;
    int itemIndex;

    TextView commentCompleteTextView = (TextView)findViewById(R.id.commentCompleteTextView);

    EditText commentNameEditText = (EditText)findViewById(R.id.commentNameEditText);
    EditText commentEditText = (EditText)findViewById(R.id.commentEditText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        itemIndex = getIntent().getIntExtra("ITEM_INDEX", itemIndex);
        myItem = itemManager.getItem(itemIndex);
    }
    public void cancel(View view){

    }
    public void comment(View view){
        if(commentNameEditText.getText().toString()!=""){
            if(commentEditText.getText().toString()!=""){
                myItem.addComment(commentNameEditText.getText().toString(), commentEditText.getText().toString());
                Intent intent = new Intent(this, ItemInformationActivity.class);
                String s = Integer.toString(itemIndex);
                intent.putExtra("ITEM_INDEX", s);
                startActivity(intent);
            }
            else{
                commentCompleteTextView.setVisibility(TextView.VISIBLE);
            }
        }
        else{
            commentCompleteTextView.setVisibility(TextView.VISIBLE);
        }
    }
}
