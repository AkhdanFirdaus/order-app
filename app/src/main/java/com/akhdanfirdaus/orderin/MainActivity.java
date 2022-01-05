package com.akhdanfirdaus.orderin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        TextView emailView = findViewById(R.id.email_edt);
        TextView passwordView = findViewById(R.id.password_edt);
        TextView regEmailView = findViewById(R.id.reg_email_edt);
        TextView regPasswordView = findViewById(R.id.reg_password_edt);

        Button loginButton = findViewById(R.id.login_button);
        Button registerButton = findViewById(R.id.register_button);

        loginButton.setOnClickListener(view -> {
            String email = emailView.getText().toString();
            String password = passwordView.getText().toString();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            Log.d("FirebaseAuthTag", "signInWithEmail:success");
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                            this.finish();
                        } else {
                            Log.w("FirebaseAuthTag", "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        registerButton.setOnClickListener(view -> {
            String email = regEmailView.getText().toString();
            String password = regPasswordView.getText().toString();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            Log.d("FirebaseAuthTag", "createUserWithEmailAndPassword:success");
                            Toast.makeText(getApplicationContext(), "Berhasil Registrasi", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.w("FirebaseAuthTag", "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}