package GUI;

import existances.Music;
import existances.PlayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlaylistPanel extends JPanel implements ActionListener {
      JLabel playlists;
      JPanel showPlaylists;
      PlayList playList;
    JButton add_playlist_button;
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
          add_playlist_button = new JButton("add PlayLists");
          add(add_playlist_button,BorderLayout.SOUTH);
          add_playlist_button.addActionListener(this);


      }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(add_playlist_button))
        {
            playList = new PlayList("Reyhaneh");

            Music music1 = new Music("E://1.mp3","1");
            Music music2 = new Music("E://2.mp3","2");
            Music music3 = new Music("E://3.mp3","3");
            Music music4 = new Music("E://4.mp3","4");
            playList.add(music1);
            playList.add(music2);
            playList.add(music3);
            playList.add(music4);

        }
    }
    PlayList getPlayList(){
        return playList;
    }

}
