package com.adityakhedekar.khedubaba.androidpictureinpicturedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button pipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goPIPMode(View view){
        enterPictureInPictureMode();
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);

        textView = findViewById(R.id.textView);
        pipButton = findViewById(R.id.goPIPButton);
        if (isInPictureInPictureMode){
            //Going in PIP
            pipButton.setVisibility(View.INVISIBLE);
            Objects.requireNonNull(getSupportActionBar()).hide();
            textView.setText(R.string.in_pip_mode);
        }
        else{
            //Going out og PIPI
            pipButton.setVisibility(View.VISIBLE);
            Objects.requireNonNull(getSupportActionBar()).show();
            textView.setText(R.string.hello_world);
        }
    }
}
