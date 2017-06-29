package com.example.juanrubio.fbla_app_final;

/**
 * Created by YaFeng Xiong on 6/27/2017.
 */

public class Product { //TODO: the product class is unnecessary...this should be in the Item class
    public String name;
    public String price;
    public int imageId;
    //public boolean isChecked;

    public Product(String name, String price, int imageId/*, boolean isChecked*/){
        this.name = name;
        this.price = price;
        this.imageId = imageId;
        //this.isChecked = isChecked;

    }


}
