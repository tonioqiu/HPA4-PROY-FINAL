package com.example.hpa4_sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import android.nfc.tech.NfcF;

public class NFCActivity extends AppCompatActivity {
    private NfcAdapter mNfcAdapter;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfcactivity2);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }


    @Override
    protected void onResume() {
        super.onResume();

        // Enable reader mode for NFC tags
        if (mNfcAdapter != null) {
            mNfcAdapter.enableReaderMode(NFCActivity.this, new NfcAdapter.ReaderCallback() {
                @Override
                public void onTagDiscovered(Tag tag) {
                }
            }, NfcAdapter.FLAG_READER_NFC_A | NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK, null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Disable reader mode
        if (mNfcAdapter != null) {
            mNfcAdapter.disableReaderMode(this);
        }
    }

}