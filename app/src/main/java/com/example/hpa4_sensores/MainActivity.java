package com.example.hpa4_sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button NFCButton;
    Button FingerprintButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NFCButton = (Button)findViewById(R.id.btnNFC);
        FingerprintButton = findViewById(R.id.btnHuellas);

        FingerprintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fingerprint_intent = new Intent(MainActivity.this, FingerPrintActivity.class);
                startActivity(fingerprint_intent);
            }
        });

        NFCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nfcintent = new Intent (MainActivity.this ,NFCActivity.class);
                startActivity(nfcintent);
            }
        });
    }
}