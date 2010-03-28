package CORE;

import CORE.Troop.*;

public class Player {

    private String name;
    private Troop[] troops;
    private Game g;

    public Player(String n, Troop[] t, Game g)
    {
        name = n;
        this.g = g;
    }

    public String getName () {
        return name;
    }

    public void setName (String val) {
        this.name = val;
    }

    public Game getGame()
    {
        return g;
    }

}
