package com.example.hpa4_sensores.videos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.hpa4_sensores.R;
import com.example.hpa4_sensores.VoiceActivity;

public class MessiVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messi_video);

        VideoView videoView = findViewById(R.id.videoView);
        Button btnRegresar = findViewById(R.id.btnRegresar);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String videoName = extras.getString("video");
        System.out.println("Esto es: " + videoName);

        String videoPath= "";

        if (videoName.equals("Messi")){
             videoPath = "android.resource://" + getPackageName() + "/" + R.raw.messi;

        }

        else if (videoName.equals("One Piece")){
             videoPath = "android.resource://" + getPackageName() + "/" + R.raw.mejorcancion;
        }


        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent videointent = new Intent (MessiVideo.this , VoiceActivity.class);
                startActivity(videointent);

            }
        });



    }
}