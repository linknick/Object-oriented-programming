package com.chungifei.oopfinalprojectuiprototype.characters;

public class Character4 extends Character{
    private static Character character=new Character4();
    public Character4()
    {
        index=3;
        name="沖田";
        classes="Saber";
        level=1;
        hp=200;
        atk=30;
        exp=0;
        required=100;
    }
    public static Character getCharacter() {return character;}
}
