package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views - converted to local variables
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);         // Changed to local variable
        TextView signupTextView = findViewById(R.id.signupText);    // Changed to local variable

        // Replaced anonymous OnClickListener with lambda
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (isValidLogin(username, password)) {
                // Successful login
                Toast.makeText(MainActivity.this, "Login Successful:)", Toast.LENGTH_SHORT).show();

                // Start HomeActivity
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // Optional: Close MainActivity
            } else {
                // Handle invalid login
                if (username.isEmpty()) {
                    usernameEditText.setError("Please enter a username.");
                } else if (password.length() < 7) {
                    passwordEditText.setError("Password must be at least 7 characters long.");
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed:(", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Replaced anonymous OnClickListener with lambda
        signupTextView.setOnClickListener(v -> {
            // Start RegistrationActivity
            Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });
    }

    private boolean isValidLogin(String username, String password) {
        return !username.isEmpty() && password.length() >= 7;
    }
}