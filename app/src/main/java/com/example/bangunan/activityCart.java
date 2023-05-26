package com.example.bangunan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class activityCart extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private List<CartItem> cartItems;

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
    }
}

