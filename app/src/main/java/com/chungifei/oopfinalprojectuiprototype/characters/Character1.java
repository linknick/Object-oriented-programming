package com.chungifei.oopfinalprojectuiprototype.characters;

public class Character1 extends Character{
    private static Character character=new Character1();
    public Character1()
    {
        index=0;
        name="不懂人心";
        classes="Saber";
        level=1;
        hp=200;
        atk=30;
        exp=0;
        required=100;
    }
    public static Character getCharacter() {return character;}
}
