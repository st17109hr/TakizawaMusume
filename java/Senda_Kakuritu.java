package com.example.takizawamusume;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Senda_Kakuritu extends AppCompatActivity {

    private Button button;
    private TextView kekka;
    private EditText edit_kakuritu, edit_kaisuu;

    private SoundPool SE;
    private int SoundId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakuritu);

        //ボタンの設定
        button = findViewById(R.id.push);

        //textviewの設定
        kekka = findViewById(R.id.text3);

        //edittextの設定
        edit_kakuritu = findViewById(R.id.Number1);
        edit_kaisuu = findViewById(R.id.Number2);

        //効果音の設定
        SE = new SoundPool(1,AudioManager.STREAM_MUSIC, 0);
        SoundId = SE.load(this, R.raw.teretere,1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //数値を入力した場合、確立と回数から結果を求める
                if(edit_kakuritu.getText().toString().length()!=0 && edit_kaisuu.getText().toString().length()!=0){
                    double double_kakuritu = Double.parseDouble(edit_kakuritu.getText().toString())/100;
                    int int_kaisuu = Integer.parseInt((edit_kaisuu.getText().toString()));
                    double A = (1-Math.pow(1-double_kakuritu,int_kaisuu))*100;
                    //小数第二位までを表示
                    BigDecimal B = new BigDecimal(String.valueOf(A));
                    B = B.setScale(2, RoundingMode.DOWN);
                    kekka.setText(String.valueOf(B)+"%");

                    //ボタンを押した際に効果音を鳴らす
                    SE.play(SoundId, 1.0f, 1.0f, 0, 0, 1);
                }
            }
        });
    }


}