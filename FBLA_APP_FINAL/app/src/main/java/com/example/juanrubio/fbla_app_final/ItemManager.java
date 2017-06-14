package com.example.juanrubio.fbla_app_final;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Juan Rubio on 4/30/2017.
 */
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class ItemManager {
    ArrayList<Item> items; //TODO: try switching to some kind of list for item management
    public ItemManager(){
        items = new ArrayList<>();
        readItemsArray(); //TODO: check if this works
    }
    public void addItem(Item item){
        items.add(item);
    }
    public Item getItem(int index){
        return items.get(index);
    }
    //Searches the items ArrayList and returns an array of Items that match the String itemName
    public Item[] searchItem(String itemName){ //TODO: find a way to do this that works if more than one item has the same name
        Item[] searchResults = new Item[50];
        int currentIndex = 0;
        //Loop through the items array comparing itemName to the current Item.getName()
        for(int i = 1; i<items.size(); i++){
            if(itemName.contains(items.get(i).getName())){
                searchResults[currentIndex] = items.get(i);
                currentIndex++;
            }
            return searchResults;
        }
        return null;
    }
    public Item getItem(Bitmap bitmap){
        //Loop through the items array comparing bitmap to the current Item.getImage()
        for(int i = 1; i<items.size(); i++){
            if(bitmap==items.get(i).getImage()){
                return items.get(i);
            }
        }
        return null;
    }
    public ArrayList<Item> getAllItems(){
        return items;
    }


    //TODO: check if the following two methods actually work

    public boolean saveItemsArray(){ //Saves the items array to internal storage. Returns true if successful
        //Check if items contains at least one Item
        if(items.get(1)!=null){
            try{
                FileOutputStream fileOut = new FileOutputStream("items.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(items);
                out.close();
                fileOut.close();
                return true;
            }catch(IOException e){
                e.printStackTrace();
                return false;
            }
        }
        else if(items.get(1)==null){
            return false;
        }
        return false;
    }
    public boolean readItemsArray(){ //Replaces the 'items' array with a copy saved in internal storage, if available. Returns true if successful
        try{
            FileInputStream fileIn = new FileInputStream("items.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            items = (ArrayList<Item>)in.readObject();
            in.close();
            fileIn.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }
}
