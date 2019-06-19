package GUI;

import javax.swing.*;
import java.awt.*;

    public class WestPanel extends JScrollPane {
        private JPanel mainPanel = new JPanel();

        public WestPanel(){
            mainPanel.setSize(100,300);
            GridBagLayout layout = new GridBagLayout();
            GridBagConstraints gbcons = new GridBagConstraints();
            mainPanel.setLayout(layout);
            JPanel jp = new JPanel();
            gbcons.fill = GridBagConstraints.VERTICAL;
            gbcons.gridx = 0;
            gbcons.gridy = 0;

            JTextField JTF = new JTextField("Library");
            JButton plusLibrary = new JButton();
            jp.add(JTF , BorderLayout.EAST);
            jp.add(plusLibrary , BorderLayout.WEST);
            mainPanel.add(jp , gbcons);

            gbcons.gridx = 0;
            gbcons.gridy = 1;
            JButton song = new JButton("Musics");
            song.setSize(new Dimension(50 , 10));
            mainPanel.add(song , gbcons);

            gbcons.gridx = 0;
            gbcons.gridy = 2;
            JButton album = new JButton("Albums");
            album.setSize(new Dimension(50 , 10));
            mainPanel.add(album , gbcons);

            gbcons.gridx = 0;
            gbcons.gridy = 3;
            JButton playlist = new JButton("PlayLIst");
            playlist.setSize(new Dimension(50 , 10));
            mainPanel.add(album , gbcons);

            JButton button = new JButton("");

            gbcons.fill = GridBagConstraints.HORIZONTAL;
            gbcons.ipady = 0;       //reset to default
           // gbcons.weighty = 1.0;   //request any extra vertical space
            gbcons.anchor = GridBagConstraints.PAGE_END; //bottom of space
            gbcons.insets = new Insets(10,0,0,0);  //top padding
            gbcons.gridx = 0;       //aligned with button 2
            gbcons.gridwidth = 2;   //2 columns wide
            gbcons.gridy = 2;       //third row
            mainPanel.add(button, gbcons);

            setViewportView(mainPanel);
            setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            //mainPanel

        }
    }
