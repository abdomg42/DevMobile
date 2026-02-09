package com.example.firstapp1;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    ImageView chien;
    ImageView chat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        chat = (ImageView) findViewById(R.id.imageChat);
        chien = (ImageView) findViewById(R.id.imageChien);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast tchat = Toast.makeText(getApplicationContext(), "Coucou Chat", Toast.LENGTH_SHORT);
                tchat.show();
                MediaPlayer mediac = MediaPlayer.create(getApplicationContext(), R.raw.chat);
                mediac.start();
            }
        });
        chien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast tchat = Toast.makeText(getApplicationContext(), "Coucou chien", Toast.LENGTH_SHORT);
                tchat.show();
                MediaPlayer media = MediaPlayer.create(getApplicationContext(), R.raw.chien);
                media.start();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }}
