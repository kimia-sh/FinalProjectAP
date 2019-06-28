package GUI;

import existances.Music;
import existances.PlayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CenterPanel extends JPanel implements ActionListener{
    JButton b1;
     ArrayList<JButton> buttonList = new ArrayList<>();
    public     PlayList playList;
    CenterPanel(){

        setBackground(Color.MAGENTA);

//        JLabel jLabel = new JLabej();
//        b1.setBackground(Color.BLACK);
//        b1.setPreferredSize(new Dimension(160 , 160));
//        b1 = new JButton("Play");
//        JFrame frame = new JFrame("JPotify");
//        frame.setLayout(new GridLayout(1,3,5,5));
//        frame.add(b1);

        //        JButton b2=new JButton();
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 1;
//        b2.setBackground(Color.BLACK);
//        add(b2);
//        PlayList playList
//        JButton b3=new JButton();
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 2;
//        b3.setBackground(Color.BLACK);
//        add(b3);
//        b3.setPreferredSize(new Dimension(160 , 160));
//        setVisible(true);
//        JButton b4=new JButton();
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 3;
//        b4.setBackground(Color.BLACK);
//        add(b4);
//        b4.setPreferredSize(new Dimension(160 , 160));
//        setVisible(true);
//        JButton b5=new JButton();
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 4;
//        b5.setBackground(Color.BLACK);
//        add(b5);
//        b5.setPreferredSize(new Dimension(160 , 160));
//        setVisible(true);
//        JButton b6=new JButton();
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 5;
//        b6.setBackground(Color.BLACK);
//        add(b6);
//        b6.setPreferredSize(new Dimension(160 , 160));
//        setVisible(true);
//        JButton c1=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 0;
//        c1.setBackground(Color.CYAN);
//        c1.setPreferredSize(new Dimension(160 , 50));
//        add(c1);
//        JButton c2=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 1;
//        c2.setBackground(Color.CYAN);
//        add(c2);
//        c2.setPreferredSize(new Dimension(160 , 50));
//        JButton c3=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 2;
//        c3.setBackground(Color.CYAN);
//        add(c3);
//        c3.setPreferredSize(new Dimension(160 , 50));
//        setVisible(true);
//        JButton c4=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 3;
//        c4.setBackground(Color.CYAN);
//        add(c4);
//        c4.setPreferredSize(new Dimension(160 , 50));
//        setVisible(true);
//        JButton c5=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 4;
//        c5.setBackground(Color.CYAN);
//        add(c5);
//        c5.setPreferredSize(new Dimension(160 , 50));
//        setVisible(true);
//        JButton c6=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 5;
//        c6.setBackground(Color.CYAN);
//        add(c6);
//        c6.setPreferredSize(new Dimension(160 , 50));
//        setVisible(true);
//        JButton a1=new JButton();
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 0;
//        a1.setBackground(Color.BLACK);
//        a1.setPreferredSize(new Dimension(160 , 160));
//        add(a1);
//        JButton a2=new JButton();
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 1;
//        a2.setBackground(Color.BLACK);
//        add(a2);
//        a2.setPreferredSize(new Dimension(160 , 160));
//        JButton a3=new JButton();
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 2;
//        a3.setBackground(Color.BLACK);
//        add(a3);
//        a3.setPreferredSize(new Dimension(160 , 160));
//        setVisible(true);
//        JButton a4=new JButton();
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 3;
//        a4.setBackground(Color.BLACK);
//        add(a4);
//        a4.setPreferredSize(new Dimension(160 , 160));
//        setVisible(true);
//        JButton a5=new JButton();
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 4;
//        a5.setBackground(Color.BLACK);
//        add(a5);
//        a5.setPreferredSize(new Dimension(160 , 160));
//        setVisible(true);
//        JButton a6=new JButton();
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 5;
//        a6.setBackground(Color.BLACK);
//        add(a6);
//        a6.setPreferredSize(new Dimension(160 , 160));
//        setVisible(true);
//        JButton d1=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 0;
//        d1.setBackground(Color.CYAN);
//        d1.setPreferredSize(new Dimension(160 , 50));
//        add(d1);
//        JButton d2=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 1;
//        d2.setBackground(Color.CYAN);
//        add(d2);
//        d2.setPreferredSize(new Dimension(160 , 50));
//        JButton d3=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 2;
//        d3.setBackground(Color.CYAN);
//        add(d3);
//        d3.setPreferredSize(new Dimension(160 , 50));
//        setVisible(true);
//        JButton d4=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 3;
//        d4.setBackground(Color.CYAN);
//        add(d4);
//        d4.setPreferredSize(new Dimension(160 , 50));
//        setVisible(true);
//        JButton d5=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 4;
//        d5.setBackground(Color.CYAN);
//        add(d5);
//        d5.setPreferredSize(new Dimension(160 , 50));
//        setVisible(true);
//        JButton d6=new JButton("artist:" +"          " +"name:" +"       ");
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 20;
//        gbcons.gridy = 5;
//        d6.setBackground(Color.CYAN);
//        add(d6);
//        d6.setPreferredSize(new Dimension(160 , 50));
//        setVisible(true);
    }
    void setPlayList(PlayList p){
        playList = p;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0 ; i < buttonList.size(); i++) {
            if (e.getSource().equals(buttonList.get(i))) {
                System.out.println(i);
                playList.getListMusic().get(i).play();
            }
        }

    }
    public void drawPlaylist(){
        //pList.setListMusic(p.getListMusic());
        JButton b;

        for(int i = 0 ; i < playList.getNumberOfPlaylistMusic(); i++) {
            b = new JButton(playList.getListMusic().get(i).getTitle());
            b.setPreferredSize(new Dimension(160 , 160));
            b.addActionListener(this);
            buttonList.add(b);
        }
        for(int i = 0 ; i < playList.getNumberOfPlaylistMusic(); i++) {
            add(buttonList.get(i));
        }
    }
}
