package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI (){
        setSize(1000 , 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WestPanel westPanel = new WestPanel();
        add(westPanel , BorderLayout.WEST);
        setVisible(true);
    }
}
