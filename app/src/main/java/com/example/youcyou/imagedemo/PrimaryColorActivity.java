package com.example.youcyou.imagedemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * @since 16/7/4.
 */
public class PrimaryColorActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private ImageView imageView;
    private SeekBar hueSeekBar, saturationSeekBar, lumSeekBar;

    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;

    private float mHue,mSaturation,mLum;
    private Bitmap bitmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primarycolor);

        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.test3);

        imageView = (ImageView) findViewById(R.id.image);
        hueSeekBar = (SeekBar) findViewById(R.id.seekbar_hue);
        saturationSeekBar = (SeekBar) findViewById(R.id.seekbar_saturation);
        lumSeekBar = (SeekBar) findViewById(R.id.seekbar_lum);

        hueSeekBar.setOnSeekBarChangeListener(this);
        saturationSeekBar.setOnSeekBarChangeListener(this);
        lumSeekBar.setOnSeekBarChangeListener(this);

        hueSeekBar.setMax(MAX_VALUE);
        saturationSeekBar.setMax(MAX_VALUE);
        lumSeekBar.setMax(MAX_VALUE);

        hueSeekBar.setProgress(MID_VALUE);
        saturationSeekBar.setProgress(MID_VALUE);
        lumSeekBar.setProgress(MID_VALUE);

        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekbar_hue:
                mHue = (progress - MID_VALUE )* 1.0F / MID_VALUE * 180;
                break;
            case R.id.seekbar_saturation:
                mSaturation = progress * 1.0F /MID_VALUE;
                break;
            case R.id.seekbar_lum:
                mLum = progress * 1.0F /MID_VALUE;
                break;
        }
        imageView.setImageBitmap(ImageHelper.handleImageEffect(bitmap,mHue,mSaturation,mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
