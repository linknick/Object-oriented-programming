package com.chungifei.oopfinalprojectuiprototype.characters;

public class Character3 extends Character{
    private static Character character=new Character3();
    public Character3()
    {
        index=2;
        name="黑色的貞德";
        classes="Avenger";
        level=1;
        hp=150;
        atk=40;
        exp=0;
        required=100;



    }
    public static Character getCharacter() {return character;}
}