package Client.UI.Swing.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by beniamino on 18/02/16.
 */
public class MyFrame extends JFrame {

    JLabel jl = new JLabel("Buona lezione");
    JButton uno = new JButton("Uno");
    JButton due = new JButton("Due");
    JButton tre = new JButton("Tre");
    JButton quattro = new JButton("Quattro");
    JButton cinque = new JButton("Cinque");

    public MyFrame() {
        super("Flow Layout");
        Container c = this.getContentPane();
        c.add(jl);
        c.setLayout(new GridLayout(4,4));
        for (int i=0; i<15; i++)
            c.add(new JButton(String.valueOf(i)));
        /*
        c.add(uno);
        c.add(due);
        c.add(tre);
        c.add(quattro);
        c.add(cinque);
        */
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
