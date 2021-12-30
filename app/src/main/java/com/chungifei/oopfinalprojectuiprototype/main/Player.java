package com.chungifei.oopfinalprojectuiprototype.main;

import com.chungifei.oopfinalprojectuiprototype.characters.Character;

import java.util.Vector;

public class Player {
    public boolean[] unlocked = {false,false,false,false,false,false,false,false,false};
    public boolean isUnlocked(int index) {
        return unlocked[index];
    }
    public Team team =new Team(5);
    public Character[] characters=new Character[Character.NUM_CHARACTERS];
    private static Player currentPlayer = new Player();
    public static Player getPlayer()
    {
        return currentPlayer;
    }
    private Player()
    {
        for(int i=0;i< Character.NUM_CHARACTERS;i++)
        {
            characters[i]=Character.getCharacter(i);
        }
    }
    private int getCharacterNum()
    {
        int num=0;
        for(int i=0;i<9;i++) {
            if (unlocked[i]) {
            num++;
            }
        }
        return num;
    }

}
