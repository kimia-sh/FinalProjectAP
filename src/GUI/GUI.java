package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
      JPanel westPanel;
      JPanel northPanel;
//      JPanel southPanel;
      JPanel eastPanel;
      JPanel centerPanel;
      JPanel northWest;
       SpringLayout springLayout;
      JTextArea area;
      JButton search;

    public GUI (){
        setSize(1366, 730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
//        WestPanel westPanel = new WestPanel();
        SouthPanel southPanel=new SouthPanel();
        NorthPanel northPanel=new NorthPanel();
//        CenturPanel centurPanel = new CenturPanel();
//        EastPanel eastpanel = new EastPanel();
        westPanel=new JPanel();
        eastPanel=new JPanel();

        centerPanel=new JPanel();
        setEastPanel();
        setWestPanel();

//        setSouthPanel();
        setCenterPanel();
        getContentPane().add(westPanel , BorderLayout.WEST);
        getContentPane().add(southPanel , BorderLayout.SOUTH);
        getContentPane().add(northPanel,BorderLayout.NORTH);
        getContentPane().add(centerPanel , BorderLayout.CENTER);
        getContentPane().add(eastPanel , BorderLayout.EAST);
        setVisible(true);
    }

    public void setWestPanel() {
        westPanel.setLayout(new BorderLayout());
        northWest=new JPanel(new GridBagLayout());

        GridBagConstraints gbcons = new GridBagConstraints();
        gbcons.fill = GridBagConstraints.VERTICAL;
        JPanel jp = new JPanel(new BorderLayout());
        gbcons.gridx = 0;
        gbcons.gridy = 0;
        JButton home = new JButton("Home");
        northWest.add(home,gbcons);
        JLabel jlabel = new JLabel("Library");
        JButton addLibrary = new JButton("+");
        addLibrary.setBounds(50 , 100 , 50 , 100);
        jp.add( jlabel, BorderLayout.WEST);
        jp.add(addLibrary , BorderLayout.EAST);
        gbcons.gridx = 0;
        gbcons.gridy = 1;
        northWest.add(jp,gbcons);
        gbcons.gridx = 0;
        gbcons.gridy = 2;
        JButton song = new JButton("Musics");
        song.setSize(new Dimension(50 , 10));
        northWest.add(song , gbcons);
        gbcons.gridx = 0;
        gbcons.gridy = 3;
        JButton album = new JButton("Albums");
        album.setSize(new Dimension(50 , 10));
        northWest.add(album , gbcons);
        westPanel.add(northWest,BorderLayout.NORTH);
        PlaylistPanel playlistPanel=new PlaylistPanel();
        westPanel.add(playlistPanel,BorderLayout.CENTER);
        JLabel artWork=new JLabel("art work");
        westPanel.add(artWork,BorderLayout.SOUTH);
    }

    public void setEastPanel() {
        JLabel jLabel = new JLabel();
        jLabel.setForeground(Color.CYAN);
        jLabel.setText(jLabel.getText()+"Friend Activity");
        //jLabel.add(button);

        GridBagConstraints gbcons = new GridBagConstraints();
        JLabel jLabel1 = new JLabel();
        jLabel.setBackground(Color.RED);
        eastPanel.add(jLabel);
//        JButton b1=new JButton();
//        gbcons.fill = GridBagConstraints.HORIZONTAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 1;
//        b1.setBackground(Color.yellow);
//        b1.setPreferredSize(new Dimension(100 , 100));
//        add(b1);
        //jLabel.setText(jLabel.getText()+"Name " +
        //      " artWork " +
        //    " SongName");
        //jpanel1.add(jLabel);
        //jpanel1.setForeground(Color.BLUE);
        //jpanel1.setPreferredSize(new Dimension(350, 190));

        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 1;
        eastPanel.setBackground(Color.BLACK);


    }



    public void setCenterPanel() {
        centerPanel.setBackground(Color.MAGENTA);
        GridBagConstraints gbcons = new GridBagConstraints();
        JLabel jLabel = new JLabel();
        JButton b1=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 0;
        b1.setBackground(Color.BLACK);
        b1.setPreferredSize(new Dimension(160 , 160));
        centerPanel.add(b1);
        JButton b2=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 1;
        b2.setBackground(Color.BLACK);
        centerPanel.add(b2);
        b2.setPreferredSize(new Dimension(160 , 160));
        JButton b3=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 2;
        b3.setBackground(Color.BLACK);
        centerPanel.add(b3);
        b3.setPreferredSize(new Dimension(160 , 160));
        JButton b4=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 3;
        b4.setBackground(Color.BLACK);
        centerPanel.add(b4);
        b4.setPreferredSize(new Dimension(160 , 160));

        JButton b5=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 4;
        b5.setBackground(Color.BLACK);
        centerPanel.add(b5);
        b5.setPreferredSize(new Dimension(160 , 160));

        JButton b6=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 5;
        b6.setBackground(Color.BLACK);
        centerPanel.add(b6);
        b6.setPreferredSize(new Dimension(160 , 160));
        JButton c1=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 0;
        c1.setBackground(Color.CYAN);
        c1.setPreferredSize(new Dimension(160 , 50));
        centerPanel.add(c1);
        JButton c2=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 1;
        c2.setBackground(Color.CYAN);
        centerPanel.add(c2);
        c2.setPreferredSize(new Dimension(160 , 50));
        JButton c3=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 2;
        c3.setBackground(Color.CYAN);
        centerPanel.add(c3);
        c3.setPreferredSize(new Dimension(160 , 50));

        JButton c4=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 3;
        c4.setBackground(Color.CYAN);
        centerPanel.add(c4);
        c4.setPreferredSize(new Dimension(160 , 50));

        JButton c5=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 4;
        c5.setBackground(Color.CYAN);
        centerPanel.add(c5);
        c5.setPreferredSize(new Dimension(160 , 50));

        JButton c6=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 5;
        c6.setBackground(Color.CYAN);
        centerPanel.add(c6);
        c6.setPreferredSize(new Dimension(160 , 50));

        JButton a1=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 0;
        a1.setBackground(Color.BLACK);
        a1.setPreferredSize(new Dimension(160 , 160));
        centerPanel.add(a1);
        JButton a2=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 1;
        a2.setBackground(Color.BLACK);
        centerPanel.add(a2);
        a2.setPreferredSize(new Dimension(160 , 160));
        JButton a3=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 2;
        a3.setBackground(Color.BLACK);
        centerPanel.add(a3);
        a3.setPreferredSize(new Dimension(160 , 160));

        JButton a4=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 3;
        a4.setBackground(Color.BLACK);
        centerPanel.add(a4);
        a4.setPreferredSize(new Dimension(160 , 160));

        JButton a5=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 4;
        a5.setBackground(Color.BLACK);
        centerPanel.add(a5);
        a5.setPreferredSize(new Dimension(160 , 160));

        JButton a6=new JButton();
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 5;
        a6.setBackground(Color.BLACK);
        centerPanel.add(a6);
        a6.setPreferredSize(new Dimension(160 , 160));

        JButton d1=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 0;
        d1.setBackground(Color.CYAN);
        d1.setPreferredSize(new Dimension(160 , 50));
        centerPanel.add(d1);
        JButton d2=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 1;
        d2.setBackground(Color.CYAN);
        centerPanel.add(d2);
        d2.setPreferredSize(new Dimension(160 , 50));
        JButton d3=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 2;
        d3.setBackground(Color.CYAN);
        centerPanel.add(d3);
        d3.setPreferredSize(new Dimension(160 , 50));
        setVisible(true);
        JButton d4=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 3;
        d4.setBackground(Color.CYAN);
        centerPanel.add(d4);
        d4.setPreferredSize(new Dimension(160 , 50));

        JButton d5=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 4;
        d5.setBackground(Color.CYAN);
        centerPanel.add(d5);
        d5.setPreferredSize(new Dimension(160 , 50));
        JButton d6=new JButton("artist:" +"          " +"name:" +"       ");
        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 20;
        gbcons.gridy = 5;
        d6.setBackground(Color.CYAN);
        centerPanel.add(d6);
        d6.setPreferredSize(new Dimension(160 , 50));
    }
}
