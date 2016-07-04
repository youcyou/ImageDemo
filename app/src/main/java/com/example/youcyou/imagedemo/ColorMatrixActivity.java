package com.example.youcyou.imagedemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

/**
 * @since 16/7/4.
 */
public class ColorMatrixActivity extends Activity {

    private ImageView imageView;
    private GridLayout gridLayout;
    private Button changeButton, resetButton;
    private EditText[] editTexts = new EditText[20];

    private int width, height;
    private Bitmap bitmap;
    private float[] mColorMaxtrix = new float[20];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colormatrix);

        imageView = (ImageView) findViewById(R.id.imageview);
        gridLayout = (GridLayout) findViewById(R.id.gridview);
        changeButton = (Button) findViewById(R.id.button_change);
        resetButton = (Button) findViewById(R.id.button_reset);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test1);
        imageView.setImageBitmap(bitmap);

        gridLayout.post(new Runnable() {
            @Override
            public void run() {
                width = gridLayout.getWidth() / 5;
                height = gridLayout.getHeight() / 4;
                addEdittext();
                initMatrix();
            }
        });

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMatrix();
                setImageMatrix();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initMatrix();
                getMatrix();
                setImageMatrix();
            }
        });

    }

    private void getMatrix() {
        for (int i = 0; i < 20; i++) {
            mColorMaxtrix[i] = Float.parseFloat(editTexts[i].getText().toString());
        }
    }

    private void setImageMatrix() {
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(mColorMaxtrix);

        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);

        imageView.setImageBitmap(bmp);

    }

    private void addEdittext() {
        for (int i = 0; i < 20; i++) {
            EditText editText = new EditText(this);
            editTexts[i] = editText;
            gridLayout.addView(editText, width, height);
        }
    }

    private void initMatrix() {
        for (int i = 0; i < 20; i++) {
            if (i % 6 == 0) {
                editTexts[i].setText(String.valueOf(1));
            } else {
                editTexts[i].setText(String.valueOf(0));
            }
        }
    }
}
