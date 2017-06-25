package com.example.juanrubio.fbla_app_final;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by Juan Rubio on 4/30/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class Item {
    public String myName;
    public String myPrice;
    public String myDescription;
    public String myCondition;
    public Bitmap myImage;
    public String[][] comments;
    public Item(String name, String price, String description, String condition, Bitmap image){
        myName = name;
        myPrice = price;
        myDescription = description;
        myCondition = condition;
        myImage = image;
        comments = new String[1000][1000];
    }
    public String getName(){
        return myName;
    }
    public String getPrice(){
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
    public void addComment(String commenterName, String comment, int numberOfStars){
        //find the first empty place in the array:
        for(int i = 0; i<1000; i++){
            if(comments[i][0]==null){
                comments[i][0] = commenterName;
                comments[i][1] = comment;
                comments[i][2] = Integer.toString(numberOfStars);
                return;
            }
        }
    }
    public String[][] getComments(){
        return comments;
    }
}
