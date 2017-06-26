package com.example.juanrubio.fbla_app_final;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class FeaturedItemsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ItemManager itemManager = MainActivity.getGlobalItemManager();
    CartManager cartManager = MainActivity.getGlobalCartManager();

    LinearLayout cartLayout;
    LinearLayout featuredItemsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_items);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ListView cartListView = (ListView) findViewById(R.id.cartListView);
        cartLayout = (LinearLayout) findViewById(R.id.cartLayout);


        String[] cartItemNames = cartManager.getItemNames();
        ArrayAdapter<String> cartAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cartItemNames);
        cartListView.setAdapter(cartAdapter);
        cartListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                TextView textView = (TextView)view;
                String itemName = textView.getText().toString();
                final int itemIndex = cartManager.getIndex(itemName);
                CharSequence options[] = new CharSequence[] {"Remove", "Cancel"};

                AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
                builder.setTitle("Would you like to remove "+itemName+" from your cart?");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0){
                            cartManager.removeItem(itemIndex);
                            dialog.dismiss();
                        }
                        else if(which==1){
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });


        ListView featuredItemsListView = (ListView)findViewById(R.id.featuredItemsListView);
        String[] featuredItemNames = itemManager.getAllItemNames();
        ArrayAdapter<String> featuredAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, featuredItemNames);
        featuredItemsListView.setAdapter(featuredAdapter);
        featuredItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView)view;
                String itemName = textView.getText().toString();
                final int itemIndex = itemManager.getIndex(itemName);
                Intent intent = new Intent(getBaseContext(), ItemInformationActivity.class);
                intent.putExtra("ITEM_INDEX", String.valueOf(itemIndex));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.featured_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        //I tried, but I didn't know what the name of the next activity was
        if (id == R.id.action_search){
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void reloadCart(){ //Loads the cart to start with, and reloads when it changes

    }

    public void clear(View view){ //clears the cart of all items
        cartManager.clearAllItems();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
    public void completePurchase(View view){ //purchases all items in the cart
        Intent intent = new Intent(getBaseContext(), PaymentDetailsActivity.class);
        startActivity(intent);
    }

}
