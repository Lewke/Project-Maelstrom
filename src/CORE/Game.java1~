package CORE;

import javax.swing.*;
import java.awt.*;

public class Game{

    private Map m;
    public JFrame main;
    public JPanel bPane;
    public JPanel tPane;
    public Player p1;
    public Player p2;

    public Game()
    {
        p1 = new Player("Player 1", null, this);
        p2 = new Player("Player 2", null, this);
        m = new Map(this);
    }

    private void init()
    {
        main = new JFrame("WarGame");
        main.setSize(800, 700);

        //Create the main layout objects
        bPane = new JPanel(new BorderLayout());
        JPanel sPane = new JPanel(new BorderLayout());

        tPane = new JPanel(new GridLayout(3,2));

        JLabel wLabel = new JLabel("");
        JLabel nLabel = new JLabel("Name: ");
        JLabel hLabel = new JLabel("Health: ");
        
        tPane.add(wLabel);
        tPane.add(nLabel);
        tPane.add(hLabel);

        sPane.add(tPane, BorderLayout.WEST);

        JButton att = new JButton("Attack");
        JButton mov = new JButton("Move");
        JButton idle = new JButton("Idle");

        JPanel g1 = new JPanel(new GridLayout(1,3));
        g1.add(att);
        g1.add(mov);
        g1.add(idle);

        sPane.add(g1, BorderLayout.EAST);
        bPane.add(sPane, BorderLayout.SOUTH);
        bPane.add(m.getPane(), BorderLayout.CENTER);
        
        main.setContentPane(bPane);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Game().init();
    }
 
}
