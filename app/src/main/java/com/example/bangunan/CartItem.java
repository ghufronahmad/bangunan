package com.example.bangunan;
import java.io.Serializable;

public class CartItem implements Serializable {
    private String itemName;
    private int itemPrice;

    public CartItem(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }
}
