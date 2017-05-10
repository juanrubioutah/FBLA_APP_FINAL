package com.example.juanrubio.fbla_app_final;

import android.graphics.Bitmap;

/**
 * Created by Juan Rubio on 4/30/2017.
 */

public class Item {
    public User myOwner;
    public String myName;
    public int myPrice;
    public String myDescription;
    public String myCondition;
    public Bitmap myImage;
    public Item(User owner, String name, int price, String description, String condition, Bitmap image){
        myOwner = owner;
        myName = name;
        myPrice = price;
        myDescription = description;
        myCondition = condition;
        myImage = image;
    }
    public User getOwner(){
        return myOwner;
    }
    public String getName(){
        return myName;
    }
    public int getPrice(){
        return myPrice;
    }
    public String getDescription(){
        return myDescription;
    }
    public String getCondition(){
        return myCondition;
    }
    public Bitmap getImage(){
        return myImage;
    }
}
