package CORE.Troop;

import CORE.*;

public class HeavyTroop extends Troop {

    public HeavyTroop(Player p, String n){
        mPlayer = p;
        name = n;
        speed = 2;
        damage = 90;
        maxHealth = 300;
        curHealth = 220;
    }
}
