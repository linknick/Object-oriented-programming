package com.chungifei.oopfinalprojectuiprototype.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.chungifei.oopfinalprojectuiprototype.R;

public class LevelsActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_levels);
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

    public void openFrontActivity(View view) {
        Intent intent = new Intent(this, FrontActivity.class);
        finish();
        startActivity(intent);
    }

    public void openBattleActivity(View view){
        Intent intent = new Intent(this,BattleActivity.class);
        Button b = (Button)view;
        String buttonText = b.getText().toString();
        buttonText=buttonText.replaceAll("[*a-zA-Z]", "") ;
        /*Battle battle =new Battle();
        intent.putExtra(EXTRA_BATTLE, battle);*/
        finish();
        startActivity(intent);
    }

    public void openCharactersActivity(View view) {
        Intent intent = new Intent(this, CharactersActivity.class);
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

    public void openSettingsActivity(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        finish();
        startActivity(intent);
    }

}
