package com.example.bangunan;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the main activity here
                if(username.getText().toString().equals("user") && password.getText().toString().equals("1234")){
                    Toast.makeText(Login_Activity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login_Activity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
