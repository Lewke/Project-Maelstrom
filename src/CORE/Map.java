package CORE;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import CORE.Troop.*;

public class Map implements ActionListener {

    private int size = 10;
    private Game g;
    private JPanel gPane;
    private Location[][] grid;
    private Location selected;

    public Map(Game g){
        this.g = g;
        gPane = new JPanel(new GridLayout(10,10));
        
        grid = new Location[size][size];

        JButton[] temp = new JButton[size*size];
        for (int i = 0; i < (size*size); i++)
        {
            temp[i] = new JButton("" + i);
            temp[i].addActionListener(this);
        }


        JButton tempWest;
        JButton tempEast;
        JButton tempNorth;
        JButton tempSouth;
        int tempCounter = 0;

        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                String tempString = "" + tempCounter;
                if (!tempString.endsWith("0"))
                    tempWest = temp[tempCounter-1];
                else
                    tempWest = null;

                if(!tempString.endsWith("9"))
                    tempEast = temp[tempCounter+1];
                else
                    tempEast = null;

                if(tempCounter >= size)
                    tempNorth = temp[tempCounter-10];
                else
                    tempNorth = null;
                if(!tempString.startsWith("9"))
                    tempSouth = temp[tempCounter+10];
                else
                    tempSouth = null;

                Troop troop = new CommonTroop(null, "Fred" + tempCounter);
                grid[x][y] = new Location(temp[tempCounter], tempWest, tempEast, tempNorth, tempSouth, true, this, troop);
                tempCounter++;
                gPane.add(grid[x][y].getLocation());
            }
        }
    }
    
    public JPanel getPane(){
        return gPane;
    }

    public Game getGame(){
        return g;
    }
    
    public Location getMapSquare(int x, int y){
        if (validateCoordinates(x,y))
            return grid[x][y];
        else
            throw new IllegalArgumentException("Coordinates Not Valid.");
    }
    public int getSize(){
        return size;
    }

    public Location getSelected() { return selected; }

    public int findSquareX(Location finder){
        for(int i = 0; i < size; i++)
        {
            for(int l = 0; l < size; l++)
            {
                if(grid[i][l].equals(finder))
                        return i;
            }
        }
        return -1;
    }


    public int findSquareY(Location finder){
        for(int i = 0; i < size; i++)
        {
            for(int l = 0; l < size; l++)
            {
                if(grid[i][l].equals(finder))
                        return l;
            }
        }
        return -1;
    }

    public Location findLocation(JButton but){
        for(int i = 0; i < size; i++)
        {
            for(int l = 0; l < size; l++)
            {
                if(grid[i][l].getLocation().equals(but))
                        return grid[i][l];
            }
        }
        return null;
    }

    public boolean validateCoordinates(int x, int y){
        return (x >= 0 && x < 10) && (y >= 0 && y < 10);
    }

    public Location highLightMoves(int moves, Location loc)
    {
        if (moves == 0 || loc == null)
            return null;
        else
        {
            loc.getLocation().setBackground(Color.red);
            highLightMoves(moves-1, findLocation(loc.getEast()));
            highLightMoves(moves-1, findLocation(loc.getNorth()));
            highLightMoves(moves-1, findLocation(loc.getWest()));
            highLightMoves(moves-1, findLocation(loc.getSouth()));
            return null;
        }
    }

    public void deselectAll(){
        selected = null;
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                getMapSquare(x, y).getLocation().setBackground(null);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        deselectAll();
        selected = findLocation((JButton) e.getSource());
        highLightMoves(3, findLocation((JButton) e.getSource()));
        selected.updateTroopInfo();

    }

}
