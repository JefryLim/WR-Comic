package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    TextView error;
    Button loginbtn;
    ArrayList<String> usernameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        login();
    }

    private void initialize() {
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        error = findViewById(R.id.tv_error);
        loginbtn = findViewById(R.id.b_login);
    }

    private void login() {
            loginbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                        error.setText("Username/Password must not be empty!");
                        error.setVisibility(view.VISIBLE);
                    }else if(username.getText().toString().length()<5 || username.getText().toString().length()>8) {
                        error.setText("Username length must be greater than 4 and less than 8!");
                        error.setVisibility(view.VISIBLE);
                    }else{
                        Intent intent = new Intent(LoginActivity.this, NavDrawerActivity.class);
                        intent.putExtra("username", username.getText().toString());
                        startActivity(intent);
                    }
                }
            });
    }
}