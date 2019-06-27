package GUI;

import existances.Album;
import existances.Music;
import existances.PlayList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {
    Icon icon;
    JPanel westPanel;
    JPanel northPanel;
    //      JPanel southPanel;
    JPanel eastPanel;
    JPanel centerPanel;
    JPanel northWest;
    SpringLayout springLayout;
    JTextArea area;
    JButton search;
    int type;
    PlayList playList;
    ArrayList<Music> songs;
    ArrayList<Album> albums;
    int currentAlbum;
    ArrayList<JButton> songsButtonList;
    ArrayList<JButton> playlist_buttons;
    JButton songs_button;
    JButton album_button;
    JButton add_playlist_button;
    JButton all_playlists_button;
    JPanel showPlaylists;

    public GUI (){
        songsButtonList = new ArrayList<>();
        icon = new ImageIcon();
        songs = new ArrayList<>();
        albums = new ArrayList<Album>();

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

        songs_button = new JButton("Songs");
        songs_button.setSize(new Dimension(50 , 10));
        gbcons.gridx = 0;
        gbcons.gridy = 3;
        northWest.add(songs_button );
        songs_button.addActionListener(this);

        album_button = new JButton("Albums");
        album_button.setSize(new Dimension(50 , 10));
        gbcons.gridx = 0;
        gbcons.gridy = 4;
        northWest.add(album_button , gbcons);
        album_button.addActionListener(this);

        westPanel.add(northWest,BorderLayout.NORTH);

        all_playlists_button=new JButton("playlists");
        showPlaylists=new JPanel();
        showPlaylists.setLayout(new BorderLayout());

        //          showPlaylists.setSize(new Dimension(50,1000));
        showPlaylists.setSize(0,0);
        showPlaylists.setBackground(Color.BLACK);



        JScrollPane scrollableArea = new JScrollPane(showPlaylists);
        scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        showPlaylists.add(all_playlists_button,BorderLayout.NORTH);
        showPlaylists.add(new Button("1"));
        showPlaylists.add(new Button("2"));
        showPlaylists.add(new Button("3"));

//            all_playlists_button.addActionListener(this);

//            showPlaylists.add(scrollableArea,BorderLayout.CENTER);

//            add_playlist_button = new JButton("add PlayLists");
//           showPlaylists.add(add_playlist_button,BorderLayout.SOUTH);
        westPanel.add(showPlaylists,BorderLayout.CENTER);

//        PlaylistPanel playlistPanel=new PlaylistPanel();
//        westPanel.add(playlistPanel,BorderLayout.CENTER);


//        playlist_button = new JButton("Playlist");
//        playlist_button.setPreferredSize(new Dimension(50 , 50));
//        gbcons.gridx = 0;
//        gbcons.gridy = 5;
//        westPanel.add(playlist_button);
//        playlist_button.addActionListener(this);

        JLabel artWork=new JLabel("art work");
        westPanel.add(artWork,BorderLayout.SOUTH);

    }
//        westPanel=new JPanel(new GridBagLayout());
//        westPanel.setLayout(new BorderLayout());
// //       westPanel.setLayout(null);
//
//        northWest=new JPanel(new GridBagLayout());
//
//        GridBagConstraints gbcons = new GridBagConstraints();
////
////
//        JButton home = new JButton("Home");
//        home.setPreferredSize(new Dimension(100 , 50));
////        ;//, new BorderLayout().NORTH);
//        gbcons.fill = GridBagConstraints.VERTICAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 0;
//        northWest.add(home , gbcons);
//
//        JPanel jp = new JPanel(new BorderLayout());
//        JLabel jlabel = new JLabel("Library");
//        JButton addLibrary = new JButton("+");
//        //addLibrary.setBounds(50 , 100 , 100 , 50);
//
//        jp.add( jlabel, BorderLayout.WEST);
//        jp.add(addLibrary , BorderLayout.EAST);
//        gbcons.gridx = 0;
//        gbcons.gridy = 1;
//        northWest.add(jp,gbcons);
//
//        album_button = new JButton("Albums");
////        album_button.setPreferredSize(new Dimension(50 , 50));
//album_button.setBounds(10,500,100,100);
//        gbcons.gridx = 0;
//        gbcons.gridy = 2;
//        northWest.add(album_button);//,new BorderLayout().SOUTH);
//        album_button.addActionListener(this);
//
//
//        JButton songs_button = new JButton("Songs");
//        songs_button.setPreferredSize(new Dimension(100 , 50));
//        gbcons.gridx = 0;
//        gbcons.gridy = 2;
//        northWest.add(songs_button);
//        album_button.addActionListener(this);
//
//
//
//        westPanel.add(northWest);
//
//
////        PlaylistPanel playlistPanel=new PlaylistPanel();
//
//        //JLabel playlists;
//        //JPanel showPlaylists;
//        //PlayList playList;
////            setLayout(new BorderLayout());
////            playlists=new JLabel("playlists");
////            showPlaylists=new JPanel();
//////          showPlaylists.setSize(new Dimension(50,1000));
////            showPlaylists.setSize(0,0);
////            showPlaylists.setBackground(Color.BLACK);
////            JScrollPane scrollableArea = new JScrollPane(showPlaylists);
////            scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
////            add(playlists,BorderLayout.NORTH);
////            add(scrollableArea,BorderLayout.CENTER);
//
////
////
////        songs_button = new JButton("Songs");
////        songs_button.setPreferredSize(new Dimension(100 , 200));
////        gbcons.gridx = 0;
////        gbcons.gridy = 2;
////
////            westPanel.add(songs_button,gbcons);
////            songs_button.addActionListener(this);
////            gbcons.gridx = 0;
////            gbcons.gridy = 2;
////
//
////      //  westPanel.add(playlistPanel,BorderLayout.CENTER);
////        JLabel artWork=new JLabel("art work");
////        westPanel.add(artWork,BorderLayout.SOUTH);
//    }

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

        //pList.setListMusic(p.getListMusic());
//            JButton b;
//
//            for(int i = 0 ; i < playList.getNumberOfPlaylistMusic(); i++) {
//                b = new JButton(playList.getListMusic().get(i).getTitle());
//                b.setPreferredSize(new Dimension(160 , 160));
//                b.addActionListener(this);
//                buttonList.add(b);
//            }
//            for(int i = 0 ; i < playList.getNumberOfPlaylistMusic(); i++) {
//                centerPanel.add(buttonList.get(i));
//            }
    }


    public void drawSongs(ArrayList<Music> allSongs){
        //pList.setListMusic(p.getListMusic());
        JButton b;
        songsButtonList.clear();
        centerPanel.removeAll();
        centerPanel.revalidate();
        centerPanel.repaint();
//        for( int i=0; i < centerPanel.getComponentCount(); i++)
//            centerPanel.remove(i);
        for(int i = 0 ; i < allSongs.size(); i++) {
            b = new JButton(allSongs.get(i).getTitle());
            b.setPreferredSize(new Dimension(160 , 160));
            b.addActionListener(this);
            songsButtonList.add(b);
        }
        for(int i = 0 ; i < allSongs.size(); i++) {
            centerPanel.add(songsButtonList.get(i));
        }
        setVisible(true);
        centerPanel.revalidate();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0 ; i < songsButtonList.size(); i++) {
            if (e.getSource().equals(songsButtonList.get(i))) {
                if (type == 1)
                    songs.get(i).play();
                else if (type == 2)
                    playList.getListMusic().get(i).play();
                else if (type == 3)
                    albums.get(currentAlbum).getListMusic().get(i).play();
            }
        }

        if (e.getSource().equals(album_button))
        {
            currentAlbum = 0;
            Album album = new Album("Album 1");
            Music music1 = new Music("E://1.mp3");
            Music music3 = new Music("E://3.mp3");
            Music music4 = new Music("E://4.mp3");
            album.add(music1);
            album.add(music3);
            album.add(music4);
            albums.add(album);
            type = 3;
            drawSongs(albums.get(currentAlbum).getListMusic());

        }

        //        if (e.getSource().equals(playlist_button))
//        {
//            playList = new PlayList("Reyhaneh");
//
//            Music music1 = new Music("E://1.mp3");
//            Music music2 = new Music("E://2.mp3");
//            Music music3 = new Music("E://3.mp3");
//            Music music4 = new Music("E://4.mp3");
//            playList.add(music1);
//            playList.add(music2);
//            playList.add(music3);
//            playList.add(music4);
//            type = 2;
//            drawSongs(playList.getListMusic());
//        }

        if (e.getSource().equals(songs_button))
        {
            Music music1 = new Music("E://1.mp3");
            Music music2 = new Music("E://2.mp3");
            songs.add(music1);
            songs.add(music2);
            type = 1;
            drawSongs(songs);

        }

    }

}
