package com.chungifei.oopfinalprojectuiprototype.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.chungifei.oopfinalprojectuiprototype.R;
import com.chungifei.oopfinalprojectuiprototype.characters.Character;
import com.chungifei.oopfinalprojectuiprototype.main.Battle;

import java.util.Timer;
import java.util.TimerTask;

public class BattleSceneActivity extends AppCompatActivity {
    Battle b;
    boolean show = true;
    ImageView atkImg;
    ImageView defImg;
    ImageView atkEff;
    TextView dmg;
    TextView hp;
    int atker;
    int defer;
    int noneffect;
    int effect;
    int attacker;
    int defender;

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

                if (msg.what == 1) {

                    atkImg.setImageResource(atker);
                    defImg.setImageResource(defer);
                    atkEff.setImageResource(noneffect);
                    if (b.nowMove < b.pCount)//playerturn
                    {
                        dmg.setText("Player Turn ");

                    } else {
                        dmg.setText("Enemy Turn");
                    }

                }
                else if (msg.what == 2) {
                    atkEff.setImageResource(effect);
                }
                else if(msg.what == 3)
                {
                    finish();
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
        setContentView(R.layout.activity_battle_scene);
        //b = (Battle) getIntent().getSerializableExtra("EXTRA_BATTLE");
        b=Battle.getCurrentBattle();
        Timer t = new Timer();
        t.schedule(new changeImg(), 20, 1000);
        final int atkImgId = getResources().getIdentifier("attacker", "id", getPackageName());
        atkImg = findViewById(atkImgId);
        final int defImgId = getResources().getIdentifier("defender", "id", getPackageName());
        defImg = findViewById(defImgId);
        final int dmgId=getResources().getIdentifier("damage","id",getPackageName());
        dmg=findViewById(dmgId);
        final int hpId=getResources().getIdentifier("defhp","id",getPackageName());
        hp=findViewById(hpId);
        effect = getResources().getIdentifier("attack", "drawable", getPackageName());
        noneffect = getResources().getIdentifier("none", "drawable", getPackageName());
        final int effectId = getResources().getIdentifier("attack_effect", "id", getPackageName());
        atkEff = findViewById(effectId);
    }


    public class changeImg extends TimerTask {
        @Override
        public void run() {

            Message msg = mHandler.obtainMessage();
            if (show) {
                if (b.eCount > 0 && b.pCount > 0) {
                    if (atkImg != null) {

                        int atkIndex = b.battleList.elementAt(b.nowMove).index;
                        final String atkStr = String.format("%02d", atkIndex);
                        atker = getResources().getIdentifier("character_" + atkStr, "drawable", getPackageName());
                        attacker=b.nowMove;
                    }


                    if (defImg != null) {
                        int defIndex;
                        if (b.nowMove < b.pCount) {
                            defIndex = b.battleList.elementAt(b.pCount).index;
                            defender = b.pCount;
                        } else {
                            defIndex = b.battleList.elementAt(0).index;
                            defender = 0;
                        }
                        final String defStr = String.format("%02d", defIndex);
                        defer = getResources().getIdentifier("character_" + defStr, "drawable", getPackageName());
                    }
                    b.battleList.elementAt(b.nowMove).attack(b.battleList.elementAt(defender));
                    msg.what = 1;
                    msg.sendToTarget();
                    if (b.battleList.elementAt(defender).isDead()) {
                        b.battleList.remove(defender);
                        if (defender == 0) {
                            b.nowMove -= 1;
                            b.pCount -= 1;
                        } else {
                            b.eCount -= 1;
                        }
                    }
                }
                else
                {
                    msg.what=3;
                    msg.sendToTarget();
                }
                show=false;
            }
            else
            {
                msg.what=2;
                msg.sendToTarget();
                show=true;
                b.nowMove++;
                if (b.nowMove >= b.battleList.size()) {
                    b.nowMove = 0;
                }
            }
        }
    }
}

