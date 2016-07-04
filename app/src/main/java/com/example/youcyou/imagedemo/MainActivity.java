package com.example.youcyou.imagedemo;

import android.graphics.ColorMatrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0,50);//R
        hueMatrix.setRotate(1,50);//G
        hueMatrix.setRotate(2,50);//B

        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(50);

    }
}
