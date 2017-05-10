package com.example.juanrubio.fbla_app_final;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Juan Rubio on 4/30/2017.
 */

public class ItemManager {
    Item[] items; //TODO: try switching to some kind of list for item management
    public ItemManager(){
        items = new Item[1000];
        readItemsArray(); //TODO: check if this works
    }
    public void addItem(Item item){
        //Find the first empty index to add an item to
        for(int i = 0; i<items.length; i++){
            if(items[i]==null){
                items[i] = item;
            }
        }
    }
    public Item getItem(int index){
        return items[index];
    }
    public Item[] searchItem(String itemName){ //TODO: find a way to do this that works if more than one item has the same name
        Item[] searchResults = new Item[50];
        int currentIndex = 0;
        //Loop through the items array comparing itemName to the current Item.getName()
        for(int i = 0; i<items.length; i++){
            if(itemName.contains(items[i].getName())){
                searchResults[currentIndex] = items[i];
                currentIndex++;
            }
            return searchResults;
        }
        return null;
    }
    public Item getItem(Bitmap bitmap){
        //Loop through the items array comparing bitmap to the current Item.getImage()
        for(int i = 0; i<items.length; i++){
            if(bitmap==items[i].getImage()){
                return items[i];
            }
        }
        return null;
    }
    public Item[] getAllItems(){
        return items;
    }


    //TODO: check if the following two methods actually work

    public boolean saveItemsArray(){ //Saves the items array to internal storage. Returns true if successful
        //Check if items contains at least one Item
        if(items[0]!=null){
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
        else if(items[0]==null){
            return false;
        }
        return false;
    }
    public boolean readItemsArray(){ //Replaces the 'items' array with a copy saved in internal storage, if available. Returns true if successful
        try{
            FileInputStream fileIn = new FileInputStream("items.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            items = (Item[])in.readObject();
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
