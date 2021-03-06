package com.example.youcyou.imagedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button primaryColorButton,colorMatrixButton,pixelsEffectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        primaryColorButton = (Button) findViewById(R.id.primary_color);
        primaryColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PrimaryColorActivity.class));
            }
        });

        colorMatrixButton = (Button) findViewById(R.id.color_matrix);
        colorMatrixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ColorMatrixActivity.class));
            }
        });

        pixelsEffectButton = (Button) findViewById(R.id.pixels_effect);
        pixelsEffectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PixelsEffectActivity.class));
            }
        });

    }
}
