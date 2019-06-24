package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI (){
        setSize(1366, 730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        WestPanel westPanel = new WestPanel();
        SouthPanel southPanel=new SouthPanel();
        NorthPanel northPanel=new NorthPanel();
        getContentPane().add(westPanel , BorderLayout.WEST);
        getContentPane().add(southPanel , BorderLayout.SOUTH);
        getContentPane().add(northPanel,BorderLayout.NORTH);


        setVisible(true);
    }
}
