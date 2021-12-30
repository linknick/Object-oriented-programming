package com.chungifei.oopfinalprojectuiprototype.main;

import com.chungifei.oopfinalprojectuiprototype.characters.Character;

public class Team {
    public int size;
    private Character[] members;
    public Team(int n)
    {
    size=n;
    members=new Character[size];
    }
    public void setMember(Character c, int n)
    {
     this.members[n]=c;
    }
    public boolean checkMember(int n)
    {
        if(members[n]!=null) {
        return true;
        }
        else{
            return false;
        }
    }
    public boolean checkDup(int n)
    {
        for(int i=0;i<size;i++)
        {
            if(members[i]!=null&&members[i].index==Character.getCharacter(n).index) {
                return true;
            }
        }
        return false;
    }
    public Character getMembers(int n) {
        return members[n];
    }
}
