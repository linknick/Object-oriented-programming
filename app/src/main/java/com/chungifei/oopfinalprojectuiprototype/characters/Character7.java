package com.chungifei.oopfinalprojectuiprototype.characters;

public class Character7 extends Character{
    private static Character character=new Character7();
    public Character7()
    {
        index=6;
        name="BBA";
        classes="Lancer";
        level=1;
        hp=200;
        atk=30;
        exp=0;
        required=100;
    }
    public static Character getCharacter() {return character;}
}
