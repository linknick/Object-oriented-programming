package com.chungifei.oopfinalprojectuiprototype.characters;

import java.io.Serializable;

public class Character implements Serializable {
    public static final int NUM_CHARACTERS = 9;
    public String name;
    public String classes;
    public int level;
    public int hp;
    public int atk;
    public int exp;
    public int required;
    public int index;
    public Character()
    {
        index=-1;
        name="C";
        classes="Class";
        level=1;
        hp=100;
        atk=20;
        exp=0;
        required=100;
    }
    public static Character getCharacter(int n)
    {
        switch (n)
        {
            case 0 : return new Character1();
            case 1 : return new Character2();
            case 2 : return new Character3();
            case 3 : return new Character4();
            case 4 : return new Character5();
            case 5 : return new Character6();
            case 6 : return new Character7();
            case 7 : return new Character8();
            case 8 : return new Character9();
        }
        return  null;
    }
    public void getExp(int n) {
        exp += n;
        while (exp >= required && level <= 100) {
            exp-=required;
            required+=100;
            enhence();
        }
    }
    private void enhence()
    {
        level+=1;
        atk+=20;
        hp+=50;
    }
}
