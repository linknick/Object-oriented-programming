package com.chungifei.oopfinalprojectuiprototype.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.chungifei.oopfinalprojectuiprototype.R;
import com.chungifei.oopfinalprojectuiprototype.characters.Character;
import com.chungifei.oopfinalprojectuiprototype.main.Player;

import java.util.Timer;
import java.util.TimerTask;

public class GachaActivity extends AppCompatActivity {

    ImageView img ;
    int imageId;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 1) {
                img.setImageResource(imageId);
            }
            super.handleMessage(msg);
        }
    };
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
        setContentView(R.layout.activity_gacha);
        /*Timer t=new Timer();
        t.schedule(new changeImg(),0,1000);*/
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

    public void drawCard(View view){
        int result=(int)(Math.random()*9);
        Player.getPlayer().unlocked[result]=true;
        final int imgId =getResources().getIdentifier("drawResult","id", getPackageName());
        img = findViewById(imgId);
        final String iStr = String.format("%02d", result);
        imageId = getResources().getIdentifier("character_"+iStr  , "drawable", getPackageName());
        img.setImageResource(imageId);

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
    public class changeImg extends TimerTask{
        int i=0;
        @Override
        public void run() {

            final int imgId =getResources().getIdentifier("drawResult","id", getPackageName());
            img = findViewById(imgId);
            final String iStr = String.format("%02d", i);
            imageId = getResources().getIdentifier("character_"+iStr  , "drawable", getPackageName());
            img.postInvalidate();
            Message msg = mHandler.obtainMessage();
            msg.what = 1;
            msg.sendToTarget();
            i++;
            if(i== Character.NUM_CHARACTERS)
                i=0;
        }
    }
}
