package com.example.firstapp1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class Animaux extends AppCompatActivity {
    MediaPlayer panda;
    MediaPlayer loup;
    MediaPlayer tiger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.animaux_main2);
        panda = findViewById(R.id.imagepanda);
        loup = findViewById(R.id.imageloup);
        tiger = findViewById(R.id.imagetiger);
        panda.onClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Animaux.this,Panda.class);
                startActivity(intent);
            }
                      }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}