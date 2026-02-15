package com.example.firstapp1;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Loup extends AppCompatActivity {
    VideoView loup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loup);
        loup = findViewById(R.id.videoLoup);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.loup;
        Uri uri = Uri.parse(videoPath);
        loup.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        loup.setMediaController(mediaController);
        mediaController.setAnchorView(loup);

        loup.start();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}
