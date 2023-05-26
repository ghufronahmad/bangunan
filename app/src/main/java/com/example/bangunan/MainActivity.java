package com.example.bangunan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

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
                        // Handle Home item click
                        // Add your desired functionality here
                        return true;
                    case R.id.all:
                        // Handle All Product item click
                        // Add your desired functionality here
                        return true;
                    case R.id.cart:
                        // Handle Cart item click
                        // Add your desired functionality here
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

        // LinearLayout alatLayout = findViewById(R.id.hkhk);
        // RelativeLayout perlengkapanLayout = findViewById(R.id.perlengkapan);
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
