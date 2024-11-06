package com.example.loginpage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    EditText regUsername;
    EditText regEmail;
    EditText regPassword;
    EditText regConfirmPassword;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);  // Link to activity_registration.xml

        // Initialize views
        regUsername = findViewById(R.id.regUsername);
        regEmail = findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);
        regConfirmPassword = findViewById(R.id.regConfirmPassword);
        registerButton = findViewById(R.id.registerButton);

        // Set click listener for the register button using a lambda expression
        registerButton.setOnClickListener(v -> {
            String usernameInput = regUsername.getText().toString();
            String emailInput = regEmail.getText().toString();
            String passwordInput = regPassword.getText().toString();
            String confirmPasswordInput = regConfirmPassword.getText().toString();

            // Validate inputs
            if (usernameInput.isEmpty()) {
                Toast.makeText(RegistrationActivity.this, "Please enter a username.", Toast.LENGTH_SHORT).show();
            } else if (emailInput.isEmpty()) {
                Toast.makeText(RegistrationActivity.this, "Please enter an email address.", Toast.LENGTH_SHORT).show();
            } else if (passwordInput.length() < 7) {
                Toast.makeText(RegistrationActivity.this, "Password must be at least 7 characters long.", Toast.LENGTH_SHORT).show();
            } else if (!passwordInput.equals(confirmPasswordInput)) {
                Toast.makeText(RegistrationActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
            } else {
                // Registration successful
                Toast.makeText(RegistrationActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                // Here you can add logic to store user data, such as in a database or SharedPreferences
            }
        });
    }
}
