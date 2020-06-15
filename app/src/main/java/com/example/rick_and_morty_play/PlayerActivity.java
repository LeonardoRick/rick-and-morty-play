package com.example.rick_and_morty_play;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // Hide ActionBar
        getSupportActionBar().hide();

        // Hide native StatusBar and NavigationBar
        View decorView = getWindow().getDecorView(); // Returns object that allows screen manipulation
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); // Set FullScreen flag to screen manipulation


        // Play Video
        videoView = findViewById(R.id.videoView);
        videoView.setMediaController(new MediaController(this)); // mediaController config (play, pause, time...)
        videoView.setVideoPath(
            "android.resource://" + // Default android prefix to access resources
            getPackageName() + // Find the package name defined after (ex: R.raw.video)
            "/" +
            R.raw.video // Where's my .mp4
        );
        videoView.start();
    }
}