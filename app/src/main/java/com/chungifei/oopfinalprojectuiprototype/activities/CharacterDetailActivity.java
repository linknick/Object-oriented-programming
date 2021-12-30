package com.chungifei.oopfinalprojectuiprototype.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.chungifei.oopfinalprojectuiprototype.characters.Character;
import com.chungifei.oopfinalprojectuiprototype.R;
import com.chungifei.oopfinalprojectuiprototype.main.Player;

public class CharacterDetailActivity extends AppCompatActivity {

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
        character = (Character) getIntent().getSerializableExtra(CharactersActivity.EXTRA_CHARACTER);
        setContentView(R.layout.activity_character_detail);
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

            final int imgId =getResources().getIdentifier("character_detail_image","id", getPackageName());
            ImageView img = findViewById(imgId);
            final String iStr = String.format("%02d", character.index);
            final int imageId = getResources().getIdentifier("character_"+iStr  , "drawable", getPackageName());

            img.setImageResource(imageId);


            final int nameId = getResources().getIdentifier("character_name", "id", getPackageName());
            TextView nameText = findViewById(nameId);
            nameText.setText(character.name);
            final int classId = getResources().getIdentifier("character_class", "id", getPackageName());
            TextView classText = findViewById(classId);
            classText.setText(character.classes);
            final int levelId = getResources().getIdentifier("character_level", "id", getPackageName());
            TextView levelText = findViewById(levelId);
            levelText.setText(Integer.toString(character.level));
            final int hpId = getResources().getIdentifier("character_hp", "id", getPackageName());
            TextView hpText = findViewById(hpId);
            hpText.setText(Integer.toString(character.hp));
            final int atkId = getResources().getIdentifier("character_atk", "id", getPackageName());
            TextView atkText = findViewById(atkId);
            atkText.setText(Integer.toString(character.atk));
            final int expId = getResources().getIdentifier("character_exp", "id", getPackageName());
            TextView expText = findViewById(expId);
            String exp=character.exp+"/"+character.required;
            expText.setText(exp);

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
    public void levelUP(View view)
    {
        Character target = Player.getPlayer().characters[character.index];
        target.getExp(character.required);
        character.getExp(character.required);
        final int nameId = getResources().getIdentifier("character_name", "id", getPackageName());
        TextView nameText = findViewById(nameId);
        nameText.setText(character.name);
        final int classId = getResources().getIdentifier("character_class", "id", getPackageName());
        TextView classText = findViewById(classId);
        classText.setText(character.classes);
        final int levelId = getResources().getIdentifier("character_level", "id", getPackageName());
        TextView levelText = findViewById(levelId);
        levelText.setText(Integer.toString(character.level));
        final int hpId = getResources().getIdentifier("character_hp", "id", getPackageName());
        TextView hpText = findViewById(hpId);
        hpText.setText(Integer.toString(character.hp));
        final int atkId = getResources().getIdentifier("character_atk", "id", getPackageName());
        TextView atkText = findViewById(atkId);
        atkText.setText(Integer.toString(character.atk));
        final int expId = getResources().getIdentifier("character_exp", "id", getPackageName());
        TextView expText = findViewById(expId);
        String exp=character.exp+"/"+character.required;
        expText.setText(exp);
    }

    private Character character;

}
