package com.chungifei.oopfinalprojectuiprototype.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.chungifei.oopfinalprojectuiprototype.R;
import com.chungifei.oopfinalprojectuiprototype.characters.Character;
import com.chungifei.oopfinalprojectuiprototype.main.Player;

public class CharactersActivity extends AppCompatActivity {

    public static final String EXTRA_CHARACTER = "com.example.myfirstapp.CHARACTER";
    public static int global_i=0;
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
        setContentView(R.layout.activity_characters);
        Player stubPlayer = Player.getPlayer();
        for(int i = 0; i < Character.NUM_CHARACTERS; ++i) {
            if(stubPlayer.isUnlocked(i)) {
                // If character is unlocked for player, swap lock image out for character's image.
                final String iStr = String.format("%02d", i);
                final int viewId = getResources().getIdentifier("character_" + iStr + "_image", "id", getPackageName());
                final int imageId = getResources().getIdentifier("character_" + iStr, "drawable", getPackageName());
                ImageView view = findViewById(viewId);
                view.setImageResource(imageId);
                final int j=i;
                view.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), CharacterDetailActivity.class);
                        Character character = Player.getPlayer().characters[j];
                        intent.putExtra(EXTRA_CHARACTER, character);
                        startActivity(intent);
                    }
                });
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
    public void openTeamActivity(View view) {
        Intent intent = new Intent(this, HouseActivity.class);
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

    public void openSettingsActivity(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        finish();
        startActivity(intent);
    }

}
