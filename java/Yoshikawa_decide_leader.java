package com.example.takizawamusume;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Yoshikawa_decide_leader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoshikawa_decide_leader);
        final TextView textView2 = findViewById(R.id.yoshikawa_textView2);
        final TextView text_my = findViewById(R.id.yoshikawa_text_my);
        final TextView text_right = findViewById(R.id.yoshikawa_text_right);
        final TextView text_interview = findViewById(R.id.yoshikawa_text_interview);
        final TextView text_left = findViewById(R.id.yoshikawa_text_left);
        final TextView text_open = findViewById(R.id.yoshikawa_text_open);
        final TextView text_rightTo = findViewById(R.id.yoshikawa_text_rightTo);
        final TextView text_leftTo = findViewById(R.id.yoshikawa_text_leftTo);
        Button button = findViewById(R.id.yoshikawa_button);

        //効果音の設定
        SoundPool SE = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        int SoundId = SE.load(this, R.raw.dodon,1);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //効果音を再生
                SE.play(SoundId, 1.0f, 1.0f, 0, 0, 1);

                text_my.setText("");
                text_right.setText("");
                text_interview.setText("");
                text_left.setText("");
                int randomValue1 = (int)(1 + Math.random() * 6);
                int randomValue2 = (int)(1 + Math.random() * 6);
                int sum = randomValue1 + randomValue2;
                int reverse_sum = 17 - sum;
                String str1 = new StringBuilder().append(randomValue1) + " + ";
                String str2 = new StringBuilder().append(randomValue2) + " = ";
                String str3 = String.valueOf(new StringBuilder().append(sum));
                String str = str1 + str2 + str3;
                textView2.setText(str);

                if(sum % 4 == 1) {
                    text_my.setText("↓自分");
                    text_open.setText("自分");
                }
                else if(sum % 4 == 2) {
                    text_right.setText("→下家");
                    text_open.setText("下家");
                }
                else if(sum % 4 == 3) {
                    text_interview.setText("↑対面");
                    text_open.setText("対面");
                }
                else{
                    text_left.setText("←上家");
                    text_open.setText("上家");
                }
                String str4 = "右から" + sum + "牌目で開門";
                String str5 = "(左から" + reverse_sum + "牌目で開門)";
                text_rightTo.setText(str4);
                text_leftTo.setText(str5);
            }
        });
    }
}