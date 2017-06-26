package com.example.juanrubio.fbla_app_final;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;

/**
 * Created by juanr on 5/11/2017.
 */
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class CartManager {
    ArrayList<Item> cart = new ArrayList<>();
    public void addItem(Item item){
        cart.add(item);
    }
    public Item getItem(int index){
        return cart.get(index);
    }
    public Item getItem(String name){
        for(int i = 0; i<cart.size(); i++){
            if (cart.get(i).getName().equals(name)) {
                return cart.get(i);
            }
        }
        return new Item(null, null, "-1", null, null); //Return a fake item
    }
    public ArrayList<Item> getCart(){
        return cart;
    }
    public void removeItem(int index){
        cart.remove(index);
    }
    public String[] getItemNames(){
        String[] itemNames = new String[cart.size()];
        for(int i = 0; i<cart.size(); i++){
            itemNames[i] = cart.get(i).getName();
        }
        return itemNames;
    }
    public int getIndex(String itemName){
        int index = -1;
        for(int i = 0; i<cart.size(); i++){
            if(cart.get(i).getName().equals(itemName)){
                index = i;
                return index;
            }
        }
        return index;
    }

}
