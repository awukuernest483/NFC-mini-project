package com.ernest.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ReadActivityinfo extends AppCompatActivity {

    private FrameLayout backbutton;
    private TextView messagetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_activityinfo);

        backbutton = findViewById(R.id.backbutton);
        messagetext = findViewById(R.id.messagetext);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        messagetext.setText(getIntent().getStringExtra("message"));
    }
}