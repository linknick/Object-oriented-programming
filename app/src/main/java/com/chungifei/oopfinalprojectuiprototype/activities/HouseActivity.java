package com.chungifei.oopfinalprojectuiprototype.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.chungifei.oopfinalprojectuiprototype.R;
import com.chungifei.oopfinalprojectuiprototype.main.Player;
import com.chungifei.oopfinalprojectuiprototype.main.Team;

public class HouseActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_house);
        Player stubPlayer = Player.getPlayer();
        for(int i = 0; i < Player.getPlayer().team.size; ++i) {
            if(stubPlayer.team.checkMember(i)) {
                final String iStr = String.format("%02d", i);
                final String cIndexStr= String.format("%02d", stubPlayer.team.getMembers(i).index);
                final int viewId = getResources().getIdentifier("character_" + iStr , "id", getPackageName());
                final int imageId = getResources().getIdentifier("character_" + cIndexStr, "drawable", getPackageName());
                ImageView view = findViewById(viewId);
                view.setImageResource(imageId);
            }
            }
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

    public void openSettingsActivity(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        finish();
        startActivity(intent);
    }
    public void openSelectActivity(View view)
    {
        ImageView b = (ImageView)view;
        String buttonText = b.getTag().toString();
        buttonText=buttonText.replaceAll("[*a-zA-Z]", "") ;
        buttonText=buttonText.replace("_","");
        int n=Integer.parseInt(buttonText);
        Intent intent = new Intent(this, SelectActivity.class);
        intent.putExtra("EXTRA_INT",n);
        finish();
        startActivity(intent);
    }
}
