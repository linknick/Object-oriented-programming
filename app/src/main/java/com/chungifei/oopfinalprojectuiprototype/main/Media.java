package com.chungifei.oopfinalprojectuiprototype.main;

import android.content.Context;
import android.media.MediaPlayer;

import com.chungifei.oopfinalprojectuiprototype.R;
import com.chungifei.oopfinalprojectuiprototype.activities.MainActivity;

public class Media {
    public MediaPlayer player;
    private static Media current=new Media();
    public int length;
    public Context c;
    public static Media getPlayer()
    {
        return current;
    }
    private Media()
    {
        length=0;
    }
    public void setPlayer(Context context)
    {
        if(c==null)
            {
                c=context;
                player=MediaPlayer.create(c,R.raw.lemon);
            }
    }
}
