package com.chungifei.oopfinalprojectuiprototype.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.chungifei.oopfinalprojectuiprototype.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_settings);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }
    public void openFrontActivity(View view) {
        Intent intent = new Intent(this, FrontActivity.class);
        finish();
        startActivity(intent);
    }

    public void openCharactersActivity(View view) {
        Intent intent = new Intent(this, CharactersActivity.class);
        finish();
        startActivity(intent);
    }

    public void openLevelsActivity(View view) {
        Intent intent = new Intent(this, LevelsActivity.class);
        finish();
        startActivity(intent);
    }

    public void openGachaActivity(View view) {
        Intent intent = new Intent(this, GachaActivity.class);
        finish();
        startActivity(intent);
    }

    public void openHouseActivity(View view) {
        Intent intent = new Intent(this, HouseActivity.class);
        finish();
        startActivity(intent);
    }

    public void openUserActivity(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        finish();
        startActivity(intent);
    }
    public void openVolumeActivity(View view) {
        Intent intent = new Intent(this, VolumeActivity.class);
        finish();
        startActivity(intent);
    }

}
