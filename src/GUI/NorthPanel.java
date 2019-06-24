package GUI;

import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
//
//        JFrame f = new JFrame();
//        f.getContentPane().setLayout(new BorderLayout());
//        JTextArea area = new JTextArea(1, 20);
//        JPanel jp = new JPanel();
//        jp.setLayout(new BorderLayout());
//        JButton search = new JButton("Search");
//        jp.add(search, BorderLayout.WEST);
//        jp.add(area, BorderLayout.CENTER);
//        f.setSize(300, 300);
//        f.getContentPane().add(jp, BorderLayout.NORTH);
//        f.setVisible(true);
    SpringLayout springLayout;
    JTextArea area;
    JButton search;
    public  NorthPanel(){
        springLayout=new SpringLayout();
        setLayout(springLayout);
        area= new JTextArea(2, 30);
        search= new JButton("Search");
        add(area);
        add(search);

        springLayout.putConstraint(SpringLayout.WEST, search,130,SpringLayout.WEST,this);
        springLayout.putConstraint(SpringLayout.NORTH,search,3,SpringLayout.NORTH, this);

        springLayout.putConstraint(SpringLayout.WEST,area,35,SpringLayout.EAST, search);
        springLayout.putConstraint(SpringLayout.NORTH, area,0,SpringLayout.NORTH,this);
//        springLayout.putConstraint(SpringLayout.EAST, this,750,SpringLayout.EAST,area);
        springLayout.putConstraint(SpringLayout.SOUTH, this,0,SpringLayout.SOUTH, area);



    }
    }

