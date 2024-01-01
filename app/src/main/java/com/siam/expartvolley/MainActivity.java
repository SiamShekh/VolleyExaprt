package com.siam.expartvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView res = findViewById(R.id.response);

        new VolleyString().volleyString("https://jsonplaceholder.typicode.com/posts/1", MainActivity.this, new VolleyString.VolleyCallback() {
            @Override
            public void response(String response) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                res.setText(response);
            }

            @Override
            public void error(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}