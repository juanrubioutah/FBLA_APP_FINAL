package com.example.juanrubio.fbla_app_final;

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
public class ItemManager{
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
    public int getIndex(String itemName){
        int index = -1;
        for(int i = 0; i<items.size(); i++){
            if(items.get(i).getName().equals(itemName)){
                index = i;
                return index;
            }
        }
        return index;
    }
    //Searches the items ArrayList and returns an array of Items that match the String itemName
    public Item[] searchItem(String itemName){
        Item[] searchResults = new Item[items.size()]; //as many as necessary
        int currentIndex = 0;
        //Loop through the items array comparing itemName to the current Item.getName()
        for(int i = 1; i<items.size(); i++){
            if(items.get(i).getName().contains(itemName)){
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
        if(items.get(0)!=null){
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
    public String[] getAllItemNames(){
        String[] itemNames = new String[items.size()];
        for(int i = 0; i<items.size(); i++){
            itemNames[0] = items.get(i).getName();
        }
        return itemNames;
    }
    public int getItemId(String itemName){
        for(int i = 0; i<items.size(); i++){
            if(items.get(i).getName().equals(itemName)){
                return i;
            }
        }
        return -1;
    }
}
