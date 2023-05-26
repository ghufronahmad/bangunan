package com.example.bangunan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private List<CartItem> cartItems;
    private int totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigation_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent homeIntent = new Intent(MainActivity.this, ActivityAll.class);
                        startActivity(homeIntent);
                        return true;
                    case R.id.all:
                        Intent allItemsIntent = new Intent(MainActivity.this, ActivityAll.class);
                        startActivity(allItemsIntent);
                        return true;
                    case R.id.cart:
                        Intent cartIntent = new Intent(MainActivity.this, activityCart.class);
                        startActivity(cartIntent);
                        return true;
                    case R.id.account:
                        // Handle Account item click
                        // Go to LoginActivity
                        Intent intent = new Intent(MainActivity.this, Login_Activity.class);
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });

        LinearLayout alatLayout = findViewById(R.id.alat);
        RelativeLayout perlengkapanLayout = findViewById(R.id.perlengkapan);

        alatLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, listAlatcat.class);
                startActivity(intent);
            }
        });

        perlengkapanLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, listPerlengkapancat.class);
                startActivity(intent);
            }
        });

        cartItems = new ArrayList<>();
        totalPrice = 0;
    }

    // Click listener method for "Alat" category
    public void onAlatClicked(View view) {
        Intent intent = new Intent(MainActivity.this, listAlatcat.class);
        startActivity(intent);
    }

    // Click listener method for "Perlengkapan" category
    public void onPerlengkapanClicked(View view) {
        Intent intent = new Intent(MainActivity.this, listPerlengkapancat.class);
        startActivity(intent);
    }

    // Click listener method for adding items to the cart
    public void onAddToCartClicked(View view) {
        String itemName = "";
        int itemPrice = 0;

        switch (view.getId()) {
            case R.id.buttonBor:
                itemName = "Bor";
                itemPrice = 500000;
                break;
            case R.id.buttonPalu:
                itemName = "Palu";
                itemPrice = 20000;
                break;
            case R.id.buttonobeng:
                itemName = "Obeng";
                itemPrice = 50000;
                break;
            case R.id.buttontang:
                itemName = "Tang";
                itemPrice = 50000;
                break;
            case R.id.buttonmeteran:
                itemName = "Meteran";
                itemPrice = 10000;
                break;
        }

        addToCart(itemName, itemPrice);
        openCartActivity();
    }

    private void addToCart(String itemName, int itemPrice) {
        CartItem item = new CartItem(itemName, itemPrice);
        cartItems.add(item);
        totalPrice += itemPrice;
    }

    private void openCartActivity() {
        Intent intent = new Intent(this, activityCart.class);
        intent.putExtra("cartItems", (ArrayList<CartItem>) cartItems);
        intent.putExtra("totalPrice", totalPrice);
        startActivity(intent);
    }
}
