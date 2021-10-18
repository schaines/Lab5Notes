package com.example.lab5notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5notes", Context.MODE_PRIVATE);
        if(!sharedPreferences.getString(usernameKey, "").equals("")) {
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("message", sharedPreferences.getString(usernameKey,""));
            startActivity(intent);
        }
        else{
            setContentView(R.layout.activity_main);
        }
    }

    public void goToActivity2(View view) {
        EditText myTextField = (EditText) findViewById(R.id.username);
        String username = myTextField.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5notes", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", username).apply();

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message", username);
        startActivity(intent);
    }
}