package com.example.hpa4_sensores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.hpa4_sensores.videos.MessiVideo;

import java.util.ArrayList;

public class VoiceActivity extends AppCompatActivity {

    int count = 0;
    ImageButton imageButton;
    EditText editText;


    SpeechRecognizer speechRecognizer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        imageButton=findViewById(R.id.btnMic);
        editText=findViewById(R.id.edtMic);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO}, 1);

        }

        speechRecognizer=SpeechRecognizer.createSpeechRecognizer(this);

        Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es-MX");

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(count==0){

                    imageButton.setImageDrawable(getDrawable(R.drawable.ic_baseline_mic_24));
                    speechRecognizer.startListening(speechRecognizerIntent);
                    count=1;
                }

                else{
                    imageButton.setImageDrawable(getDrawable(R.drawable.ic_baseline_mic_off_24));
                    speechRecognizer.stopListening();
                    count=0;
                }
            }
        });

        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle results) {

                ArrayList<String> data = results.getStringArrayList(speechRecognizer.RESULTS_RECOGNITION);

                editText.setText(data.get(0));

                Intent videointent = new Intent (VoiceActivity.this , MessiVideo.class);

                if(data.get(0).equals("Messi")){
                    videointent.putExtra("video", "Messi");
                    startActivity(videointent);
                }

                else if(data.get(0).equals("One Piece")){
                    videointent.putExtra("video", "One Piece");
                    startActivity(videointent);

                }



                data.clear();








            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==1){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){

                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT);

            }

            else{
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT);

            }

        }

    }
}