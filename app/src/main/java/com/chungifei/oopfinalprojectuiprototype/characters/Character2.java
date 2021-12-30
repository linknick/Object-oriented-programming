package com.chungifei.oopfinalprojectuiprototype.characters;

public class Character2 extends Character{
    private static Character character=new Character2();
    public Character2()
    {
        index=1;
        name="梅林";
        classes="Caster";
        level=1;
        hp=150;
        atk=40;
        exp=0;
        required=100;
    }
    public static Character getCharacter() {return character;}
}