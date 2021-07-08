package com.example.takizawamusume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Button sendButton1 = findViewById(R.id.App01);
        sendButton1.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), Senda_Kakuritu.class);
            startActivity(intent);
        });

        Button sendButton2 = findViewById(R.id.App02);
        sendButton2.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), Senda_timer.class);
            startActivity(intent);
        });

        Button sendButton3 = findViewById(R.id.App03);
        sendButton3.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), Senda_Hiphip.class);
            startActivity(intent);
        });

        Button sendButton4 = findViewById(R.id.App04);
        sendButton4.setOnClickListener(v -> {
            final int REQUEST_IMAGE_CAPTURE = 1;

            // カメラを起動
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        });

        Button sendButton5 = findViewById(R.id.App05);
        sendButton5.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), Yoshikawa_decide_leader.class);
            startActivity(intent);
        });

        Button sendButton6 = findViewById(R.id.App06);
        sendButton6.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), Doi_counter.class);
            startActivity(intent);
        });
    }
}