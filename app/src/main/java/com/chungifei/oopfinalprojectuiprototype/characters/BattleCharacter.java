package com.chungifei.oopfinalprojectuiprototype.characters;


public class BattleCharacter extends Character
{
    public int Maxhp;
    public int id;
    //AttackBehavior ab=new AttackBehavior();
    public BattleCharacter(Character c)
    {

        name=c.name;
        Maxhp=c.hp;
        hp=Maxhp;
        atk=c.atk;
        index=c.index;
        //this.attackTable=c.attackTable;
    }
    public Boolean isDead()
    {
        if(hp<=0)
            return true;
        else
            return false;
    }
    public void attack(BattleCharacter c)
    {
        //ab.execute(c,atk);
        c.damaged(atk);
    }
    /*public void selectAttack(AttackBehavior selectedAB)
    {
        //ab=selectedAB;
    }*/
    public void damaged(int dmg)
    {
        hp-=dmg;
    }
}