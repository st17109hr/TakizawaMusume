package com.example.takizawamusume;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Senda_Hiphip extends AppCompatActivity {
    private Button right_hip, left_hip;
    private SoundPool SE1, SE2;
    private int SoundId1, SoundId2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiphip);

        //ボタンの設定
        right_hip = findViewById(R.id.RightHip);
        right_hip.setAlpha(0.0f);
        left_hip = findViewById(R.id.LeftHip);
        left_hip.setAlpha(0.0f);

        //効果音の設定
        SE1 = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        SoundId1 = SE1.load(this, R.raw.lefthip,1);
        SE2 = new SoundPool(1,AudioManager.STREAM_MUSIC, 0);
        SoundId2 = SE2.load(this, R.raw.righthip,1);

        right_hip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SE1.play(SoundId1,1.0f, 1.0f, 0,0,1);
            }
        });

        left_hip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SE2.play(SoundId2, 1.0f, 1.0f, 0, 0, 1);
            }
        });
    }
}