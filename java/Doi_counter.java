package com.example.takizawamusume;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Doi_counter extends AppCompatActivity {
    private Button AAA;
    private Button BBB;
    private TextView text;

    private int B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_counter);

        text = findViewById(R.id.doi_textView1);
        AAA = findViewById(R.id.doi_button1);

        //効果音の設定
        SoundPool SE = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        int SoundId = SE.load(this, R.raw.kati,1);

        AAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B = Integer.parseInt(text.getText().toString())+1;
                text.setText(String.valueOf(B));

                //効果音を再生
                SE.play(SoundId, 1.0f, 1.0f, 0, 0, 1);
            }
        });

        BBB = findViewById(R.id.doi_button2);

        BBB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("0");

                //効果音を再生
                SE.play(SoundId, 1.0f, 1.0f, 0, 0, 1);
            }
        });
    }
}