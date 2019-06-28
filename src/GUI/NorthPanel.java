package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
        JLabel username=new JLabel();
        try {
            FileReader fileReader = new FileReader("E://ap/Project/FinalProjectAP/File/information.txt");
            int input;

            String myUsername=new String("");
            while ((input = fileReader.read()) != -1){
                if((char)input!=' '){
                    Character tmpInput=(char)input;
                 myUsername=myUsername.concat(tmpInput.toString());
                }
                else break;
            }

            username.setText(myUsername);

            fileReader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        username.setFont(new Font("Serif", Font.PLAIN, 20));
        add(area);
        add(search);
        add(username);

        springLayout.putConstraint(SpringLayout.WEST, search,130,SpringLayout.WEST,this);
        springLayout.putConstraint(SpringLayout.NORTH,search,3,SpringLayout.NORTH, this);

        springLayout.putConstraint(SpringLayout.WEST,area,35,SpringLayout.EAST, search);
        springLayout.putConstraint(SpringLayout.NORTH, area,0,SpringLayout.NORTH,this);
//        springLayout.putConstraint(SpringLayout.EAST, this,750,SpringLayout.EAST,area);
        springLayout.putConstraint(SpringLayout.SOUTH, this,0,SpringLayout.SOUTH, area);



    }
    }

