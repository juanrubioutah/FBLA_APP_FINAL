package com.example.juanrubio.fbla_app_final;

import java.util.ArrayList;

/**
 * Created by juanr on 5/11/2017.
 */

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
        return new Item(null, null, -1, null, null, null); //Return a fake item
    }
    public ArrayList<Item> getCart(){
        return cart;
    }
    public void removeItem(int index){
        cart.remove(index);
    }

}
