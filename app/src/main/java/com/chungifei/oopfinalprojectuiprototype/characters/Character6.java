package com.chungifei.oopfinalprojectuiprototype.characters;

public class Character6 extends Character{
    private static Character character=new Character6();
    public Character6()
    {
        index=5;
        name="Rin";
        classes="Caster";
        level=1;
        hp=200;
        atk=30;
        exp=0;
        required=100;
    }
    public static Character getCharacter() {return character;}
}
