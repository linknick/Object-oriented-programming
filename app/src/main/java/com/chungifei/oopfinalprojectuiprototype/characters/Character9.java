package com.chungifei.oopfinalprojectuiprototype.characters;

public class Character9 extends Character{
    private static Character character=new Character9();
    public Character9()
    {
        index=8;
        name="九尾狐";
        classes="Caster";
        level=1;
        hp=200;
        atk=30;
        exp=0;
        required=100;
    }
    public static Character getCharacter() {return character;}
}
