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

    TextView commentCompleteTextView;

    EditText commentNameEditText;
    EditText commentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        commentCompleteTextView = (TextView)findViewById(R.id.commentCompleteTextView);
        commentNameEditText = (EditText)findViewById(R.id.commentNameEditText);
        commentEditText = (EditText)findViewById(R.id.commentEditText);

        itemIndex = getIntent().getIntExtra("ITEM_INDEX", itemIndex);
        myItem = itemManager.getItem(itemIndex);
    }
    public void cancel(View view){
        Intent intent = new Intent(this, ItemInformationActivity.class);
        String s = Integer.toString(itemIndex);
        intent.putExtra("ITEM_INDEX", s);
        startActivity(intent);
    }
    public void comment(View view){
        if(!(commentNameEditText.getText().toString().equals(""))){
            if(!(commentEditText.getText().toString().equals(""))){
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
