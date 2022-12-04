package com.ernest.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {

    Button explorebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        explorebutton = findViewById(R.id.explorebutton);

        explorebutton.setOnClickListener(view -> {
            boolean nxpChipAvailable = deviceSupportsMifareClassic(view.getContext());
            String messageFalse = "Sorry, your device does not support Mifare Ultralight and/or Mifare Classic NFC tags.";


            if (nxpChipAvailable) {
                Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(),messageFalse,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OnboardingActivity.this, MainActivity.class);
                startActivity(intent);

            }

        });
    }

    public boolean deviceSupportsMifareClassic(Context context) {
        FeatureInfo[] info = context.getPackageManager().getSystemAvailableFeatures();
        for (FeatureInfo i : info) {
            String name = i.name;
            if (name != null && name.equals("com.nxp.mifare")) {
                return true;
            }
        }
        return false;
    }
}