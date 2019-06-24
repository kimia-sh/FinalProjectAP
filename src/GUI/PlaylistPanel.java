package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlaylistPanel extends JPanel{
      JLabel playlists;
      JPanel showPlaylists;
      public PlaylistPanel(){
           setLayout(new BorderLayout());
          playlists=new JLabel("playlists");
          showPlaylists=new JPanel();
//          showPlaylists.setSize(new Dimension(50,1000));
          showPlaylists.setSize(0,0);
          showPlaylists.setBackground(Color.BLACK);
          JScrollPane scrollableArea = new JScrollPane(showPlaylists);
          scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
          add(playlists,BorderLayout.NORTH);
          add(scrollableArea,BorderLayout.CENTER);
          JButton button = new JButton("add PlayLists");
          add(button,BorderLayout.SOUTH);



      }


}
