package com.chungifei.oopfinalprojectuiprototype.activities;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.chungifei.oopfinalprojectuiprototype.R;

public class VolumeActivity extends AppCompatActivity {

    private Button normalButn;
    private Button vibrateButn;
    private Button silentButn;
    private Button upButn;
    private Button downButn;
    private AudioManager audioManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        normalButn = (Button)findViewById(R.id.normalButn);
        vibrateButn = (Button)findViewById(R.id.vibrateButn);
        silentButn = (Button)findViewById(R.id.silentButn);
        upButn = (Button)findViewById(R.id.upButn);
        downButn = (Button)findViewById(R.id.downButn);

        //取得音量控制器
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        //正常模式
        normalButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            }
        });

        //震動模式
        vibrateButn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            }
        });

        //靜音模式
        silentButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            }
        });

        //增大音量
        upButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE, 0);
            }
        });

        //減少音量
        downButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.adjustVolume(AudioManager.ADJUST_LOWER, 0);
            }
        });


    }
    public void openSettingsActivity(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        finish();
        startActivity(intent);
    }
}