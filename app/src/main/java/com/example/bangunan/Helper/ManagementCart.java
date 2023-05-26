package com.example.bangunan.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.bangunan.Domain.AlatDomain;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertAlat(AlatDomain item) {
        ArrayList<AlatDomain> listAlat = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listAlat.size(); i++) {
            if (listAlat.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        if (existAlready) {
            listAlat.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listAlat.add(item);
        }
        tinyDB.putListObject("CartList", listAlat);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<AlatDomain> getListCart() {
        ArrayList<AlatDomain> cartList = tinyDB.getListObject("CartList", AlatDomain.class);
        if (cartList == null) {
            cartList = new ArrayList<>();
        }
        return cartList;
    }
}
