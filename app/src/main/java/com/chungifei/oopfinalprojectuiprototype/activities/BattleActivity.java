package com.chungifei.oopfinalprojectuiprototype.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.chungifei.oopfinalprojectuiprototype.R;
import com.chungifei.oopfinalprojectuiprototype.characters.Character;
import com.chungifei.oopfinalprojectuiprototype.characters.Character1;
import com.chungifei.oopfinalprojectuiprototype.characters.Character2;
import com.chungifei.oopfinalprojectuiprototype.main.Battle;
import com.chungifei.oopfinalprojectuiprototype.main.Player;
import com.chungifei.oopfinalprojectuiprototype.main.Team;

public class BattleActivity extends AppCompatActivity {
    Battle b;

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
        Team enemyTeam=new Team(2);
        enemyTeam.setMember(Character.getCharacter(1),0);
        enemyTeam.setMember(Character.getCharacter(2),1);

            b = new Battle(Player.getPlayer().team, enemyTeam);

            setContentView(R.layout.activity_battle);
            Intent intent = new Intent(this, BattleSceneActivity.class);
            intent.putExtra("EXTRA_BATTLE", b);
            startActivity(intent);

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
            final int id=getResources().getIdentifier("bg","id",getPackageName());
            ImageView view=findViewById(id);
            try {
                Battle return_b = Battle.getCurrentBattle();
                if (return_b.pCount == 0)//player counter==0
                {
                    final int vid = getResources().getIdentifier("lose", "drawable", getPackageName());
                    view.setImageResource(vid);
                } else {
                    final int vid = getResources().getIdentifier("victory", "drawable", getPackageName());
                    view.setImageResource(vid);
                }
            }
            catch (Exception e)
            {}

        }
    }
    public void openLevelActivity(View view)
    {
        Intent intent = new Intent(this,LevelsActivity.class);
        Battle.release();
        finish();
        startActivity(intent);
    }

}
