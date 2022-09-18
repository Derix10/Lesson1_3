package com.example.lesson1_3;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText edittext1, edittext2 , edittext3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext1 = findViewById(R.id.edit_text1);
        edittext2 = findViewById(R.id.edit_text2);
        edittext3 = findViewById(R.id.edit_text3);
        Button startBtn = (Button) findViewById(R.id.button_click);
        startBtn.setOnClickListener(view -> sendEmail());
    }

    @SuppressLint("IntentReset")
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {edittext1.getText().toString()};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, edittext2.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, edittext3.getText());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}