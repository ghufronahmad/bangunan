package com.example.bangunan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityAll extends AppCompatActivity {

    private List<CartItem> cartItems;
    private int totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        cartItems = new ArrayList<>(); // List to store cart items

        Button buttonBor = findViewById(R.id.buttonBor);
        Button buttonPalu = findViewById(R.id.buttonPalu);
        Button buttonObeng = findViewById(R.id.buttonobeng);
        Button buttonTang = findViewById(R.id.buttontang);
        Button buttonMeteran = findViewById(R.id.buttonmeteran);

        View.OnClickListener addToCartClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = "";
                int itemPrice = 0;

                switch (v.getId()) {
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
        };

        buttonBor.setOnClickListener(addToCartClickListener);
        buttonPalu.setOnClickListener(addToCartClickListener);
        buttonObeng.setOnClickListener(addToCartClickListener);
        buttonTang.setOnClickListener(addToCartClickListener);
        buttonMeteran.setOnClickListener(addToCartClickListener);
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
