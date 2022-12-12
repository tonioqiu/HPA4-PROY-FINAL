package com.example.hpa4_sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button NFCButton, VoiceButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NFCButton = (Button)findViewById(R.id.btnNFC);
        VoiceButton = (Button)findViewById(R.id.btnVoice);

        NFCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nfcintent = new Intent (MainActivity.this ,NFCActivity.class);
                startActivity(nfcintent);
            }
        });

        VoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voiceintent = new Intent (MainActivity.this ,VoiceActivity.class);
                startActivity(voiceintent);
            }
        });
    }
}