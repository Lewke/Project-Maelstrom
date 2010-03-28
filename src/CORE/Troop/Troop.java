package CORE.Troop;

import CORE.*;
import javax.swing.*;
import java.awt.*;

public class Troop {

    protected Player mPlayer;
    protected String name;
    protected int speed;
    protected int damage;
    protected int maxHealth;
    protected int curHealth;

    public Troop()
    {
        //Does nothing
    }

    public Troop(Player p, String n)
    {
        mPlayer = p;
        name = n;
    }
    
    public String getName() { return name; }
    public int getHealth() { return curHealth; }
    public int getMaxHealth() { return maxHealth; }

    
}
