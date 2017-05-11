package com.example.juanrubio.fbla_app_final;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class ItemDonationActivity extends AppCompatActivity { //TODO: add padding to the xml elements

    private Uri imageCaptureUri;
    private static final int PICK_FROM_CAMERA = 1;
    private static final int PICK_FROM_FILE = 2;
    private ImageView imageView;
    public EditText itemNameEditText;
    public EditText itemPriceEditText;
    public EditText itemConditionEditText;
    public EditText itemDescriptionEditText;
    public Button chooseImageButton;
    public TextView incompleteTextView;
    public Bitmap image;
    public User demo = new User("sampleEmail", "samplePassword"); //TODO: come up with a good user management system
    ItemManager itemManager = MainActivity.getGlobalItemManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_donation);
        itemNameEditText = (EditText)findViewById(R.id.ItemNameEditText);
        itemPriceEditText = (EditText)findViewById(R.id.ItemPriceEditText);
        itemConditionEditText = (EditText)findViewById(R.id.ItemConditionEditText);
        itemDescriptionEditText = (EditText)findViewById(R.id.ItemDescriptionEditText);
        chooseImageButton = (Button)findViewById(R.id.ChooseImageButton);
        imageView = (ImageView)findViewById(R.id.DonationImageView);
        incompleteTextView = (TextView)findViewById(R.id.incompleteTextView);
        final String[] options = new String[] {"Take Picture", "Choose From Camera Roll"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, options);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Image");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                if(which==0){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 0);
                }
                else{
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 1);
                }
            }
        });
        final AlertDialog dialog = builder.create();
        chooseImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialog.show();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch(resultCode){
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    imageView.setImageURI(selectedImage);
                }
                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    imageView.setImageURI(selectedImage);
                }
                break;
        }

    }
    public void donate(View view){
        String itemName;
        int itemPrice;
        String itemCondition;
        String itemDescription;
        Bitmap itemImage;
        //Check that all of the fields are completed, then store the values
        if(!(itemNameEditText.getText()==null)){
            itemName = itemNameEditText.toString();
        }
        else{
            incompleteTextView.setVisibility(View.VISIBLE);
            return;
        }
        if(!(itemPriceEditText.getText()==null)){
            String tempPrice = itemPriceEditText.getText().toString();
            try{
                itemPrice = Integer.parseInt(tempPrice);
            }catch(Exception e){
                e.printStackTrace();
                incompleteTextView.setVisibility(View.VISIBLE);
                return;
            }
        }
        else{
            incompleteTextView.setVisibility(View.VISIBLE);
            return;
        }
        if(!(itemConditionEditText.getText()==null)){
            itemCondition = itemConditionEditText.getText().toString();
        }
        else{
            incompleteTextView.setVisibility(View.VISIBLE);
            return;
        }
        if(!(itemDescriptionEditText.getText()==null)){
            itemDescription = itemDescriptionEditText.getText().toString();
        }
        else{
            incompleteTextView.setVisibility(View.VISIBLE);
            return;
        }
        //Submitting an image is optional, so the "else" statment sets the image equal to null
        if(image!=null){
            itemImage = image;
        }
        else{
            itemImage = null;
        }
        //Create a new item using all of the above attributes.
        Item myItem = new Item(demo, itemName, itemPrice, itemDescription, itemCondition, itemImage);
        itemManager.addItem(myItem);
        //itemManager.saveItemsArray();
        Intent intent = new Intent(this, ConfirmDonationActivity.class);
        startActivity(intent);
    }
    public void cancel(View view){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
