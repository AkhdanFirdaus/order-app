package com.akhdanfirdaus.orderin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView usernameView = findViewById(R.id.username_edt);
        TextView passwordView = findViewById(R.id.password_edt);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(view -> {
            String username = usernameView.getText().toString();
            String password = passwordView.getText().toString();

            if (username.equals("akhdan") && password.equals("password")) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                this.finish();
            } else {
                Toast.makeText(getApplicationContext(), "Wrong Username/Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}