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
public class PaymentDetailsActivity extends AppCompatActivity {

    ItemManager myItemManager = MainActivity.getGlobalItemManager();
    Item myItem;
    int myIndex;

    TextView incompleteTextView;

    EditText creditCardNumberEditText;
    EditText creditCardExpirationEditText;
    EditText creditCardCVVEditText;

    int creditCardNumber;
    String creditCardExpiration;
    int creditCardCVV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        incompleteTextView = (TextView)findViewById(R.id.incompleteTextView);
        creditCardNumberEditText = (EditText)findViewById(R.id.purchaseCreditCardNumber);
        creditCardExpirationEditText = (EditText)findViewById(R.id.purchaseCreditCardExpiration);
        creditCardCVVEditText = (EditText)findViewById(R.id.purchaseCreditCardCVV);

        Intent intent = getIntent();
        myIndex = intent.getIntExtra("itemIndex", 0);

        myItem = myItemManager.getItem(myIndex);

    }
    public void purchase(View view){
        if(!(creditCardNumberEditText.getText().toString().equals(""))){
            if(!(creditCardExpirationEditText.getText().toString().equals(""))){
                if(!(creditCardCVVEditText.getText().toString().equals(""))){
                    try{
                        creditCardNumber = Integer.parseInt(creditCardNumberEditText.getText().toString());
                    }
                    catch(Exception e){
                        e.printStackTrace();
                        incompleteTextView.setVisibility(View.VISIBLE);
                        return;
                    }
                    creditCardExpiration = creditCardExpirationEditText.getText().toString();
                    try{
                        creditCardCVV = Integer.parseInt(creditCardCVVEditText.getText().toString());
                    }
                    catch(Exception e){
                        e.printStackTrace();
                        incompleteTextView.setVisibility(View.VISIBLE);
                        return;
                    }
                    Intent intent = new Intent(getBaseContext(), PurchaseCompletedActivity.class);
                    startActivity(intent);
                }
                incompleteTextView.setVisibility(View.VISIBLE);
                return;
            }
            incompleteTextView.setVisibility(View.VISIBLE);
            return;
        }
        incompleteTextView.setVisibility(View.VISIBLE);
        return;
    }
    public void cancel(View view){
        Intent intent = new Intent(this, FeaturedItemsActivity.class);
        startActivity(intent);
    }
}
