package com.example.bangunan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
