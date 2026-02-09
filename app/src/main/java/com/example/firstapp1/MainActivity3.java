package com.example.firstapp1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {

    private EditText editTextSentiment;
    private TextView textViewResult;
    private Map<String, Integer> sentimentDict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextSentiment = findViewById(R.id.editTextSentiment);
        Button buttonAnalyze = findViewById(R.id.buttonAnalyze);
        textViewResult = findViewById(R.id.textViewResult);

        initSentimentDict();

        buttonAnalyze.setOnClickListener(v -> analyzeSentiment());
    }

    private void initSentimentDict() {
        sentimentDict = new HashMap<>();
        // Positive words
        sentimentDict.put("happy", 1);
        sentimentDict.put("good", 1);
        sentimentDict.put("great", 1);
        sentimentDict.put("excellent", 1);
        sentimentDict.put("love", 1);
        sentimentDict.put("amazing", 1);
        sentimentDict.put("wonderful", 1);
        sentimentDict.put("joy", 1);
        sentimentDict.put("best", 1);
        sentimentDict.put("nice", 1);
        sentimentDict.put("awesome", 1);
        sentimentDict.put("cool", 1);
        sentimentDict.put("glad", 1);

        // Negative words
        sentimentDict.put("sad", -1);
        sentimentDict.put("bad", -1);
        sentimentDict.put("terrible", -1);
        sentimentDict.put("hate", -1);
        sentimentDict.put("awful", -1);
        sentimentDict.put("worst", -1);
        sentimentDict.put("angry", -1);
        sentimentDict.put("poor", -1);
        sentimentDict.put("horrible", -1);
        sentimentDict.put("disappointed", -1);
        sentimentDict.put("boring", -1);
        sentimentDict.put("ugly", -1);
    }

    private void analyzeSentiment() {
        String input = editTextSentiment.getText().toString().toLowerCase().trim();
        if (input.isEmpty()) {
            textViewResult.setText("Please enter some text.");
            return;
        }

        // Split by whitespace and punctuation
        String[] words = input.split("[\\s\\p{Punct}]+");
        int score = 0;

        for (String word : words) {
            Integer wordScore = sentimentDict.get(word);
            if (wordScore != null) {
                score += wordScore;
            }
        }

        String sentiment;
        if (score > 0) {
            sentiment = "Positive \uD83D\uDE0A";
        } else if (score < 0) {
            sentiment = "Negative \uD83D\uDE1E";
        } else {
            sentiment = "Neutral \uD83D\uDE10";
        }

        String resultText = "Sentiment: " + sentiment + "\n(Score: " + score + ")";
        textViewResult.setText(resultText);
    }
}
