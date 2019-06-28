package GUI;

import existances.PlayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WestPanel extends JPanel {
//        private JPanel mainWestPanel = new JPanel();
//
//        public WestPanel(){
//            mainWestPanel.setSize(800,300);
//            GridBagLayout layout = new GridBagLayout();
//            GridBagConstraints gbcons = new GridBagConstraints();
//            mainWestPanel.setLayout(layout);
//            JPanel jp = new JPanel();
//            gbcons.fill = GridBagConstraints.VERTICAL;
//            //jp.setBounds(50 , 100 , 100 , 50);
//            gbcons.gridx = 0;
//            gbcons.gridy = 0;
//            JButton Home = new JButton("Home");
//            mainWestPanel.add(Home);
//
//            JLabel jlabel = new JLabel("Library");
//            //ImageIcon icon = new ImageIcon("Spotifypic ",
//              //      "a pretty but meaningless splat");
//            //jlabel = new JLabel("Image and Text", icon, JLabel.CENTER);
//            //jp.add( jlabel, BorderLayout.EAST);
//            gbcons.gridx = 0;
//            gbcons.gridy = 1;
//            JButton addLibrary = new JButton("+");
//            addLibrary.setBounds(50 , 100 , 50 , 100);
//            jp.add( jlabel, BorderLayout.WEST);
//            jp.add(addLibrary , BorderLayout.EAST);
//            mainWestPanel.add(jp , gbcons);
//
//            gbcons.gridx = 0;
//            gbcons.gridy = 2;
//            JButton song = new JButton("Musics");
//            song.setSize(new Dimension(50 , 10));
//            mainWestPanel.add(song , gbcons);
//
//            gbcons.gridx = 0;
//            gbcons.gridy = 3;
//            JButton album = new JButton("Albums");
//            album.setSize(new Dimension(50 , 10));
//            mainWestPanel.add(album , gbcons);//+++++++++
//
//            gbcons.gridx = 0;
//            gbcons.gridy = 4;
//            JButton playlist = new JButton("PlayLists");
//            playlist.setSize(new Dimension(50 , 10));
//            mainWestPanel.add(playlist , gbcons);
//
//            JButton button = new JButton("add PlayLists");
//
//            gbcons.fill = GridBagConstraints.HORIZONTAL;
//            gbcons.ipady = 0;       //reset to default
//            gbcons.weighty = 2;   //request any extra vertical space
//            gbcons.anchor = GridBagConstraints.PAGE_END; //bottom of space
//            gbcons.insets = new Insets(0,0,0,0);  //top padding
//            gbcons.gridx = 0;       //aligned with button 2
//            gbcons.gridwidth = 1;   //2 columns wide
//            gbcons.gridy = 5;       //third row
//            mainWestPanel.add(button, gbcons);
//
//            setViewportView(mainWestPanel);
//            setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//
//
//        }
        private JPanel north;
    PlayList playList;
        public WestPanel(){

            setLayout(new BorderLayout());
            north=new JPanel(new GridBagLayout());
            GridBagConstraints gbcons = new GridBagConstraints();
            gbcons.fill = GridBagConstraints.VERTICAL;
            JPanel jp = new JPanel(new BorderLayout());
            JButton home = new JButton("Home");
            gbcons.gridx = 0;
            gbcons.gridy = 0;

            north.add(home,gbcons);
            JLabel jlabel = new JLabel("Library");
            JButton addLibrary = new JButton("+");
            addLibrary.setBounds(50 , 100 , 50 , 100);
            jp.add( jlabel, BorderLayout.WEST);
            jp.add(addLibrary , BorderLayout.EAST);
            gbcons.gridx = 0;
            gbcons.gridy = 1;
            north.add(jp,gbcons);
            gbcons.gridx = 0;
            gbcons.gridy = 2;
            JButton song = new JButton("Musics");
            song.setSize(new Dimension(50 , 10));
            north.add(song , gbcons);
            gbcons.gridx = 0;
            gbcons.gridy = 3;
            JButton album = new JButton("Albums");
            album.setSize(new Dimension(50 , 10));
            north.add(album , gbcons);
            add(north,BorderLayout.NORTH);
//            PlaylistPanel playlistPanel=new PlaylistPanel();
//            playList = playlistPanel.getPlayList();


            JLabel artWork=new JLabel("art work");
            add(artWork,BorderLayout.SOUTH);
        }
    PlayList getPlayList(){
        return playList;
    }

}
