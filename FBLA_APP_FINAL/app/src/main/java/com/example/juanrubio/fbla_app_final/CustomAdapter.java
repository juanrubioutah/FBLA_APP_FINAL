package com.example.juanrubio.fbla_app_final;

/**
 * Created by YaFeng Xiong on 6/27/2017.
 */

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class CustomAdapter extends ArrayAdapter<Item> {
     Context context;
     int resource;
     ArrayList<Item> products = null;
     public CustomAdapter(Context context, int resource, ArrayList<Item> products) {
         super(context, resource, products);
         this.context = context;
         this.resource = resource;
         this.products = products;

     }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item product = products.get(position);
        if(convertView==null)
            convertView = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false);

        TextView productNameTextView = (TextView)convertView.findViewById(R.id.item_name);
        TextView productPriceTextView = (TextView)convertView.findViewById(R.id.item_price);
        //CheckBox productDeleteCheckBox = (CheckBox)convertView.findViewById(R.id.check_delete);
        ImageView productImageView = (ImageView)convertView.findViewById(R.id.item_image);

        productNameTextView.setText(product.getName());
        productPriceTextView.setText(product.getPrice());
        //productDeleteCheckBox.setChecked(product.isChecked);
        productImageView.setImageResource(product.imageId);

        return convertView;
    }

}

