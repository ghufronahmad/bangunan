package com.example.bangunan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class activityCart extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private List<CartItem> cartItems;
    private int totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Retrieve the cart items from the intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            cartItems = (List<CartItem>) extras.getSerializable("cartItems");
        } else {
            cartItems = new ArrayList<>(); // Create an empty list if no items are passed
        }

        // Set up RecyclerView and Adapter
        recyclerView = findViewById(R.id.recyclerViewCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(cartAdapter);

        // Calculate the total amount
        totalAmount = calculateTotalAmount(cartItems);

        // Display the total amount
        TextView totalAmountTextView = findViewById(R.id.textView8);
        totalAmountTextView.setText("Rp" + String.valueOf(totalAmount));

        // Set up bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_bottom_cart);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent homeIntent = new Intent(activityCart.this, ActivityAll.class);
                        startActivity(homeIntent);
                        return true;
                    case R.id.all:
                        Intent allItemsIntent = new Intent(activityCart.this, ActivityAll.class);
                        startActivity(allItemsIntent);
                        return true;
                    case R.id.cart:
                        // Already in the cart activity, do nothing
                        return true;
                    case R.id.account:
                        Intent accountIntent = new Intent(activityCart.this, Login_Activity.class);
                        startActivity(accountIntent);
                        return true;
                }
                return false;
            }
        });
    }

    private int calculateTotalAmount(List<CartItem> items) {
        int total = 0;
        for (CartItem item : items) {
            total += item.getItemPrice();
        }
        return total;
    }
}
