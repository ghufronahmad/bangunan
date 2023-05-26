package com.example.bangunan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAll extends AppCompatActivity {

    private int totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        // Get references to the buttons
        Button buttonBor = findViewById(R.id.buttonBor);
        Button buttonPalu = findViewById(R.id.buttonPalu);
        Button buttonObeng = findViewById(R.id.buttonobeng);
        Button buttonTang = findViewById(R.id.buttontang);
        Button buttonMeteran = findViewById(R.id.buttonmeteran);

        // Set click listeners for the buttons
        buttonBor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add item to the cart
                addToCart(500000);

                // Open the cart activity
                openCartActivity();
            }
        });

        buttonPalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add item to the cart
                addToCart(20000);

                // Open the cart activity
                openCartActivity();
            }
        });

        buttonObeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add item to the cart
                addToCart(50000);

                // Open the cart activity
                openCartActivity();
            }
        });

        buttonTang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add item to the cart
                addToCart(50000);

                // Open the cart activity
                openCartActivity();
            }
        });

        buttonMeteran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add item to the cart
                addToCart(10000);

                // Open the cart activity
                openCartActivity();
            }
        });
    }

    private void addToCart(int itemPrice) {
        // Add your logic here to add the item to the cart
        // You can maintain a list of items or use a database to store the cart items
        // Update the total price as well
        totalPrice += itemPrice;
    }

    private void openCartActivity() {
        Intent intent = new Intent(this, activityCart.class);
        startActivity(intent);
    }
}
