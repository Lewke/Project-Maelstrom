package CORE;

import javax.swing.*;
import CORE.Troop.*;

public class Location {

    private JButton location;
    private JButton locWest;
    private JButton locEast;
    private JButton locNorth;
    private JButton locSouth;
    private boolean walkable;
    private Troop onLoc;
    private Map m;

    public Location(JButton l, JButton lw, JButton le, JButton ln, JButton ls, boolean walk, Map m, Troop troop)
    {
        location = l;
        locWest = lw;
        locEast = le;
        locNorth = ln;
        locSouth = ls;
        walkable = walk;
        onLoc = troop;
        this.m = m;
    }

    public boolean isNextTo(JButton but)
    {
        if(but.equals(locWest) || but.equals(locEast) || but.equals(locNorth) || but.equals(locSouth))
            return true;
        else
            return false;
    }

    public JButton getLocation() { return location; }
    public JButton getEast(){ return locEast; }
    public JButton getWest(){ return locWest; }
    public JButton getNorth(){ return locNorth; }
    public JButton getSouth(){ return locSouth; }
    public boolean isWalkable() { return walkable; }

    public void updateTroopInfo(){
        ((JLabel)m.getGame().tPane.getComponent(1)).setText("Name: " + onLoc.getName());
        ((JLabel)m.getGame().tPane.getComponent(2)).setText("Health: " + onLoc.getHealth() + "/" + onLoc.getMaxHealth());
    }
}
