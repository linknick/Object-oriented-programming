package com.chungifei.oopfinalprojectuiprototype.main;

import android.support.design.internal.BaselineLayout;

import com.chungifei.oopfinalprojectuiprototype.characters.BattleCharacter;
import com.chungifei.oopfinalprojectuiprototype.characters.Character;

import java.io.Serializable;
import java.util.Vector;

public class Battle implements Serializable {
    public int pCount;
    public int eCount;
    public Vector<BattleCharacter> battleList;
    public int nowMove=0;
    private static  Battle currentBattle=new Battle();

    private   Battle()
    {
    }
    public Battle(Team p, Team e)
    {
        currentBattle.battleList = new Vector<BattleCharacter>();
        BattleCharacter bc;
        currentBattle.pCount = 0;
        for (int i = 0; i < p.size; i++) {
            if(p.getMembers(i)!=null)
            {
                bc = new BattleCharacter(p.getMembers(i));
                bc.id=i;
                currentBattle.battleList.add(bc);
                currentBattle.pCount++;
            }
        }
        currentBattle.eCount = 0;
        for (int i = 0; i < e.size; i++) {
            if(e.getMembers(i)!=null) {
                bc = new BattleCharacter(e.getMembers(i));
                currentBattle.battleList.add(bc);
                currentBattle.eCount++;
            }
        }
    }

    public static Battle getCurrentBattle() {
        return currentBattle;
    }
    public static void release()
    {
        currentBattle=null;
        currentBattle=new Battle();
    }

}