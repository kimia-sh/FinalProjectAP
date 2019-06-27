package GUI;

import existances.Album;
import existances.Music;
import existances.PlayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {
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
    ArrayList<PlayList> playLists;
    ArrayList<Music> songs;
    ArrayList<Album> albums;
    int currentAlbum;
    ArrayList<JButton> songsButtonList;
    ArrayList<JButton> playlist_buttons;
    JButton songs_button;
    JButton album_button;
    JButton add_playlist_button;
    JLabel all_playlists_button;
    JButton addLibrary;
    JButton addPlayList;
    JList list;

    public GUI() {

        songsButtonList = new ArrayList<>();
        songs = new ArrayList<>();
        albums = new ArrayList<Album>();
        playLists = new ArrayList<PlayList>();
        PlayList playList = new PlayList("Rock");

        Music music1 = new Music("E://musicPlayer//01. Are You Lonely (feat. ISÁK).mp3", "Lonely");
        Music music2 = new Music("E://musicPlayer//02. Lull.mp3", "Lull");
        Music music3 = new Music("E://musicPlayer//14 - Adagio.mp3", "Adagio");
        Music music4 = new Music("E://musicPlayer//Alan_Walker_–_All_Falls_Down_Lyrics.mp3", "Alan_Walker");
        Music music5 = new Music("E://musicPlayer//Dela nazde kasi benshin.mp3", "Dela nazde");
        Music music6 = new Music("E://musicPlayer//Wiz Khalifa - See You Again.mp3", "Khalifa");
        Music music7 = new Music("E://musicPlayer//Playing-By-Heart-Yanni-HD-1280p-X-720p_924412.mp3", "Yanni");
        Music music8 = new Music("E://musicPlayer//Mehrzad Khajehamiri - Athanasia .mp3", "Athanasia");
        songs.add(music1);
        songs.add(music2);
        songs.add(music3);
        songs.add(music4);
        songs.add(music5);
        songs.add(music6);
        songs.add(music7);
        songs.add(music8);

        Album album = new Album("Album 1");
        album.add(music1);
        album.add(music3);
        album.add(music4);
        albums.add(album);

        playList.add(music1);
        playList.add(music2);
        playList.add(music3);
        playList.add(music4);
        playLists.add(playList);
        PlayList playList2 = new PlayList("Classic");
        playList2.add(music4);
        playList2.add(music7);
        playList2.add(music8);
        playLists.add(playList2);
        PlayList playList3 = new PlayList("Pop");
        playList3.add(music3);
        playList3.add(music6);
        playList3.add(music8);
        playLists.add(playList3);

        setSize(1366, 730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
//        WestPanel westPanel = new WestPanel();
        SouthPanel southPanel = new SouthPanel();
        NorthPanel northPanel = new NorthPanel();
//        CenturPanel centurPanel = new CenturPanel();
//        EastPanel eastpanel = new EastPanel();
        westPanel = new JPanel();
        eastPanel = new JPanel();

        centerPanel = new JPanel();
        setEastPanel();
        setWestPanel();

//        setSouthPanel();
        setCenterPanel();
        getContentPane().add(westPanel, BorderLayout.WEST);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        getContentPane().add(northPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(eastPanel, BorderLayout.EAST);
        setVisible(true);
    }

    public void setWestPanel() {
        westPanel.setLayout(new BorderLayout());
        northWest = new JPanel(new GridBagLayout());

        GridBagConstraints gbcons = new GridBagConstraints();
        gbcons.fill = GridBagConstraints.VERTICAL;
        JPanel jp = new JPanel(new BorderLayout());
        JPanel jp2 = new JPanel(new BorderLayout());

        gbcons.gridx = 0;
        gbcons.gridy = 0;
        JButton home = new JButton("Home");
        northWest.add(home, gbcons);

        JLabel playListLabel = new JLabel("Playlist");
        addPlayList = new JButton("+");
        addPlayList.setBounds(50 , 100 , 50 , 100);
        addPlayList.addActionListener(this);
        jp2.add( playListLabel, BorderLayout.WEST);
        jp2.add(addPlayList , BorderLayout.EAST);
        gbcons.gridx = 0;
        gbcons.gridy = 1;
        northWest.add(jp2,gbcons);

        JLabel jlabel = new JLabel("Library");
        addLibrary = new JButton("+");
        addLibrary.setBounds(50 , 100 , 50 , 100);
        addLibrary.addActionListener(this);
        jp.add( jlabel, BorderLayout.WEST);
        jp.add(addLibrary , BorderLayout.EAST);
        gbcons.gridx = 0;
        gbcons.gridy = 2;
        northWest.add(jp,gbcons);

        songs_button = new JButton("Songs");
        songs_button.setBounds(50 , 100 , 100 , 100);
        gbcons.gridx = 0;
        gbcons.gridy = 3;
        northWest.add(songs_button , gbcons);
        songs_button.addActionListener(this);

        album_button = new JButton("Albums");
        album_button.setSize(new Dimension(50, 10));
        gbcons.gridx = 0;
        gbcons.gridy = 4;
        northWest.add(album_button, gbcons);
        album_button.addActionListener(this);

        westPanel.add(northWest, BorderLayout.NORTH);

//        showPlaylists=new JPanel();
//        showPlaylists.setLayout(new BorderLayout());
//
//            showPlaylists.setSize(new Dimension(50,1000));
//            showPlaylists.setSize(0,0);
//            showPlaylists.setBackground(Color.BLACK);
        //showPlaylists.add(all_playlists_button);


//        JScrollPane scrollableArea = new JScrollPane(showPlaylists);
//            scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//            showPlaylists.add(all_playlists_button,BorderLayout.NORTH);
//               showPlaylists.add(new Button("1"));
//        showPlaylists.add(new Button("2"));
//        showPlaylists.add(new Button("3"));

//            all_playlists_button.addActionListener(this);

//            showPlaylists.add(scrollableArea,BorderLayout.CENTER);

//            add_playlist_button = new JButton("add PlayLists");
//           showPlaylists.add(add_playlist_button,BorderLayout.SOUTH);

//        westPanel.add(showPlaylists,BorderLayout.CENTER);

//        PlaylistPanel playlistPanel=new PlaylistPanel();
//        westPanel.add(playlistPanel,BorderLayout.CENTER);


        all_playlists_button = new JLabel("Playlist");
        all_playlists_button.setPreferredSize(new Dimension(200, 50));
        gbcons.gridx = 0;
        gbcons.gridy = 5;
        northWest.add(all_playlists_button,gbcons);
//        all_playlists_button.addActionListener(this);
        list = new JList();
        list.setBounds(187, 51, 179, 167);
        westPanel.add(list);
        DefaultListModel DLM = new DefaultListModel();
        for (int i = 0; i < playLists.size(); i++) {
            String s = String.format(playLists.get(i).getName());
            DLM.addElement(s);
        }
        list.setModel(DLM);
        westPanel.add(list);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    type = 2;
                    drawSongs(playLists.get(list.getSelectedIndex()).getListMusic());
                }
            }
        });



        JLabel artWork = new JLabel("art work");
        westPanel.add(artWork, BorderLayout.SOUTH);

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
        jLabel.setText(jLabel.getText() + "Friend Activity");
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


    public void drawSongs(ArrayList<Music> allSongs) {
        //pList.setListMusic(p.getListMusic());
        JButton b;
        songsButtonList.clear();
        centerPanel.removeAll();
        centerPanel.revalidate();
        centerPanel.repaint();
//        for( int i=0; i < centerPanel.getComponentCount(); i++)
//            centerPanel.remove(i);
        for (int i = 0; i < allSongs.size(); i++) {
            b = new JButton(allSongs.get(i).getTitle());
            b.setIcon(allSongs.get(i).getIcon());
            b.setPreferredSize(new Dimension(160, 160));
            album_button.setSize(new Dimension(50, 10));
            GridBagConstraints gbcons = new GridBagConstraints();
            gbcons.gridx = 0;
            gbcons.gridy = 0;

            b.addActionListener(this);
            JPanel jp = new JPanel();
            JLabel jTitle = new JLabel(allSongs.get(i).getTitle());
            jTitle.setBounds(0,0,50,50);
            JLabel jArtist = new JLabel(allSongs.get(i).getArtist());
            jArtist.setBounds(0,100,50,50);
            jp.add(b);
            jp.add(jTitle,gbcons);
            jp.add(jArtist,gbcons);

            centerPanel.add(jp);
        }
//        for (int i = 0; i < allSongs.size(); i++) {
//            centerPanel.add(songsButtonList.get(i));
//        }
        setVisible(true);
        centerPanel.revalidate();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < songsButtonList.size(); i++) {
            if (e.getSource().equals(songsButtonList.get(i))) {
                if (type == 1)
                    songs.get(i).play();
                else if (type == 2)
                    playLists.get(list.getSelectedIndex()).getListMusic().get(i).play();
                else if (type == 3)
                    albums.get(currentAlbum).getListMusic().get(i).play();
            }
        }

        if (e.getSource().equals(album_button)) {
            currentAlbum = 0;
            type = 3;
            drawSongs(albums.get(currentAlbum).getListMusic());

        }

        if (e.getSource().equals(all_playlists_button)) {
//            list = new JList();
//            list.setBounds(187, 51, 179, 167);
//            westPanel.add(list);
//            DefaultListModel DLM = new DefaultListModel();
//            for (int i = 0; i < playLists.size(); i++) {
//                String s = String.format("P%d", i);
//                DLM.addElement(s);
//            }
//            list.setModel(DLM);
//            westPanel.add(list);
//            list.addListSelectionListener(new ListSelectionListener() {
//                @Override
//                public void valueChanged(ListSelectionEvent e) {
//                    if (!e.getValueIsAdjusting()) {
//                        type = 2;
//                        drawSongs(playLists.get(list.getSelectedIndex()).getListMusic());
//                    }
//                }
//            });
        }

        if (e.getSource().equals(songs_button)) {
            type = 1;
            drawSongs(songs);

        }
        if (e.getSource().equals(addLibrary)) {
            openFile();
            System.out.println(songs.size());
        }

    }

    private void openFile() {
        JFileChooser j = new JFileChooser("E://cell music");
        int r = j.showOpenDialog(null);
        FileFilter wavFilter = new FileFilter() {

            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return false;
                } else {
                    return file.getName().toLowerCase().endsWith(".mp3");
                }
            }
        };
        File selectedFile = j.getSelectedFile();
        if (r == JFileChooser.APPROVE_OPTION) {
            if (!selectedFile.isDirectory()) {
                if (j.accept(selectedFile)) {
                    Music newSong = new Music();
                    newSong.setAddress(selectedFile.getAbsolutePath());
                    songs.add(newSong);
                }
            } else {
                File[] files = j.getSelectedFiles();
                for (File f : files) {
                    Music newMusic = new Music();
                    newMusic.setAddress(f.getAbsolutePath());
                    songs.add(newMusic);
                }
            }


        }


    }
}