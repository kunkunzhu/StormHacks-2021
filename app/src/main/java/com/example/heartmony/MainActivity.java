package com.example.heartmony;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logInButton = findViewById(R.id.logInButton);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent afterLogin = new Intent(MainActivity.this, home.class);
                // ^^ provide where we are and where we want to go ^^
                startActivity(afterLogin);
             }
        });
    }
}