package com.example.lesson1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity {
private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text = findViewById(R.id.text);
        String view = getIntent().getStringExtra("key");
        text.setText(view);
    }
}