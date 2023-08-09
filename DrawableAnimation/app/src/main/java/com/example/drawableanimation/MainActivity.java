package com.example.drawableanimation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.ActionMode;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable wifiAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView=findViewById(R.id.image);
        imageView.setBackgroundResource(R.drawable.animation);
        wifiAnimation=(AnimationDrawable) imageView.getBackground();
    }

    //
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        wifiAnimation.start();
    }
}
