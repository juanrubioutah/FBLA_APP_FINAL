package com.example.juanrubio.fbla_app_final;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class AccountCreationActivity extends AppCompatActivity {

    public EditText emailTextBox;
    public EditText passwordTextBox;
    public EditText confirmPasswordTextBox;

    public String email;
    public String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        emailTextBox = (EditText)findViewById(R.id.emailTextBox);
        passwordTextBox = (EditText)findViewById(R.id.passwordTextBox);
        confirmPasswordTextBox = (EditText)findViewById(R.id.confirmPasswordTextBox);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);
    }
    public void createAccount(View view){
        //TODO: check for email validity
        if(passwordTextBox.getText().toString().equals(confirmPasswordTextBox.getText().toString())){
            password = passwordTextBox.getText().toString();
        }
        else{
            //TODO: if passwords don't match
        }

    }
    public void cancel(View view){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}

