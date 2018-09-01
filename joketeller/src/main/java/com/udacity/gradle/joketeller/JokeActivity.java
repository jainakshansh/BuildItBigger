package com.udacity.gradle.joketeller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private static final String JOKE_KEY = "JOKE";
    private TextView jokeTv;
    private String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            joke = intent.getStringExtra(JOKE_KEY);
        }

        jokeTv = findViewById(R.id.joke_tv);
        jokeTv.setText(joke);
    }
}
