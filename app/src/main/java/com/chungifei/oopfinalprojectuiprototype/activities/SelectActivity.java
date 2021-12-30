package com.chungifei.oopfinalprojectuiprototype.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.chungifei.oopfinalprojectuiprototype.R;
import com.chungifei.oopfinalprojectuiprototype.characters.Character;
import com.chungifei.oopfinalprojectuiprototype.main.Player;

public class SelectActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_select);
        Player stubPlayer = Player.getPlayer();
        for(int i = 0; i < Character.NUM_CHARACTERS; ++i) {
            if(stubPlayer.isUnlocked(i)) {
                // If character is unlocked for player, swap lock image out for character's image.
                final String iStr = String.format("%02d", i);
                final int viewId = getResources().getIdentifier("character_" + iStr , "id", getPackageName());
                final int imageId = getResources().getIdentifier("character_" + iStr, "drawable", getPackageName());
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
    public void setMember(View view)
    {
        int selectM=getIntent().getIntExtra("EXTRA_INT",0);
        ImageView b=(ImageView) view;
        int selection=Integer.parseInt(b.getTag().toString());
        if(Player.getPlayer().isUnlocked(selection)&&Player.getPlayer().team.checkDup(selection)==false) {
            Player.getPlayer().team.setMember(Player.getPlayer().characters[selection], selectM);
            Intent intent = new Intent(this, HouseActivity.class);
            finish();
            startActivity(intent);
        }
    }
}
