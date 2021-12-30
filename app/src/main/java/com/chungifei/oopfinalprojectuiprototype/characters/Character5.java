package com.chungifei.oopfinalprojectuiprototype.characters;

public class Character5 extends Character{
    private static Character character=new Character5();
    public Character5()
    {
        index=4;
        name="Golden";
        classes="King";
        level=1;
        hp=3000;
        atk=3000;
        exp=0;
        required=100;
    }
    public static Character getCharacter() {return character;}
}
