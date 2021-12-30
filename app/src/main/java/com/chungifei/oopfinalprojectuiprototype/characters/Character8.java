package com.chungifei.oopfinalprojectuiprototype.characters;

public class Character8 extends Character{
    private static Character character=new Character8();
    public Character8()
    {
        index=7;
        name="拉美西斯二世";
        classes="Rider";
        level=1;
        hp=200;
        atk=30;
        exp=0;
        required=100;
    }
    public static Character getCharacter() {return character;}
}
