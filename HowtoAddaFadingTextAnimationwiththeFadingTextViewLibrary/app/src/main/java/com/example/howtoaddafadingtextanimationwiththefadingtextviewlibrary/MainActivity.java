package com.example.howtoaddafadingtextanimationwiththefadingtextviewlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.tomer.fadingtextview.FadingTextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    //Added one dependency  " implementation 'com.tomer:fadingtextview:2.5' "

    private FadingTextView fadingTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fadingTextView = findViewById(R.id.fading_text_view);
    }

    public void startExample2(View view) {
        String[] example2 = {"And", "this", "is", "example 2"};
        fadingTextView.setTexts(example2);
        fadingTextView.setTimeout(300, TimeUnit.MILLISECONDS);
        fadingTextView.forceRefresh();
    }
}
