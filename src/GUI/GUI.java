package GUI;

import existances.Album;
import existances.Music;
import existances.PlayList;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.io.FileFilter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {
    JPanel westPanel;
    //    JPanel southPanel;
    JPanel northPanel;
    //      JPanel southPanel;
    JPanel eastPanel;
    JPanel centerPanel;
    JPanel northWest;
    SouthPanel southPanel;
    SpringLayout springLayout;
    JTextArea area;
    JButton search;
    int type;
    ArrayList<PlayList> playLists;
    ArrayList<Music> songs;
    ArrayList<Album> albums;
    int currentAlbum;
    ArrayList<JButton> songsButtonList;
    ArrayList<JButton> albumButtonlist;
    ArrayList<JButton> playlist_buttons;
    JButton songs_button;
    JButton album_button;
    JButton add_playlist_button;
    JLabel all_playlists_button;
    JButton addLibrary;
    JButton addPlayList;
    JList list;
    PlayList newPlayList;
    int currentSong;
    JButton okPlayList;
    DefaultListModel DLM;
    Music playing;

    public GUI() {

        songsButtonList = new ArrayList<>();
        albumButtonlist = new ArrayList<>();
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

        albums = new ArrayList<Album>();
        Album album1 = new Album("Iraj Bastami");
        Music music1ofalbum1 = new Music("E://albums//Iraj-Bastami-Chaharmezrab-Shooshtari-dezkade.com_.mp3", "Chaharmezrab");
        Music music2ofalbum1 = new Music("E://albums//Iraj-Bastami-Darya-dezkade.com_.mp3", "Darya");
        Music music3ofalbum1 = new Music("E://albums//Iraj-Bastami-Sazo-Avaz-dezkade.com_.mp3", "Sazo-Avaz");
        Music music4ofalbum1 = new Music("E://albums//Iraj-Bastami-Tasnife-Ghame-Eshgh-dezkade.com_.mp3", "Ghame-Eshgh");
        album1.add(music1ofalbum1);
        album1.add(music2ofalbum1);
        album1.add(music3ofalbum1);
        album1.add(music4ofalbum1);
        albums.add(album1);
        Album album2 = new Album("Homayoon Shajarian");
        Music music1ofalbum2 = new Music("E://albums//01 Ahay Khabardar [320].mp3", "Ahay_Khabardar");
        Music music2ofalbum2 = new Music("E://albums//02 Music Matn 1 [320].mp3", "02 Music Matn 1 [320]");
        album2.add(music1ofalbum2);
        album2.add(music2ofalbum2);
        albums.add(album2);
        Album album3 = new Album("Alireza Ghorbani");
        Music music1ofalbum3 = new Music("E://albums//05. Rosvaye Zamaneh.mp3", "05. Rosvaye Zamaneh");
        Music music2ofalbum3 = new Music("E://albums//04. Az Man Bogzar.mp3", "04. Az Man Bogzar");
        Music music3ofalbum3 = new Music("E://albums//03. Sazo Avaz Mahour.mp3", "03. Sazo Avaz Mahour");
        album3.add(music1ofalbum3);
        album3.add(music2ofalbum3);
        album3.add(music3ofalbum3);
        albums.add(album3);


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

        southPanel = new SouthPanel(songs,0);
        NorthPanel northPanel = new NorthPanel();

        westPanel = new JPanel();

        eastPanel = new JPanel();

        centerPanel = new JPanel();

//        southPanel = new JPanel();

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
    //    public void setSouthPanel() {
//        BorderLayout borderLayout;
//    JPanel west;
//    JPanel center;
//    JPanel east;
//    JButton previousButton ;
//    JButton nextButton ;
//    JButton pause ;
//    JLabel title;
//    JLabel artist ;
//    JLabel album ;
//    JSlider playSlider;
//    JSlider sound ;
//    JLabel passedTime;
//    JLabel time;
//        east = new JPanel(new BorderLayout());
//        west = new JPanel();
//        center = new JPanel();
//        borderLayout = new BorderLayout();
//        previousButton = new JButton("<");
//        nextButton = new JButton(">");
//        pause = new JButton("||");
//        title = new JLabel("title");
//        title.setSize(new Dimension(50, 100));
//        artist = new JLabel("artist");
//        album = new JLabel("album");
//        playSlider = new JSlider();
//        sound = new JSlider();
//        passedTime = new JLabel("passed time");
//        time = new JLabel("                                 " + "time");
//
//        setLayout(borderLayout);
//        southPanel.add(west, BorderLayout.WEST);
//        southPanel.add(center, BorderLayout.CENTER);
//        southPanel.add(east, BorderLayout.EAST);
//        east.add(sound, BorderLayout.CENTER);
//        west.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.gridwidth = 3;
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        west.add(title, gbc);
//        gbc.gridy = 1;
//        west.add(artist, gbc);
//        gbc.gridy = 2;
//        west.add(album, gbc);
//        center.setLayout(new BorderLayout(10, 0));
//        center.add(time, BorderLayout.EAST);
//        center.add(passedTime, BorderLayout.WEST);
//        center.add(playSlider, BorderLayout.CENTER);
//        JPanel buttons = new JPanel(new GridBagLayout());
//        gbc.gridy = 0;
//        gbc.gridx = 12;
//        buttons.add(previousButton, gbc);
//        gbc.gridx = 16;
//        buttons.add(pause, gbc);
//        gbc.gridx = 20;
//        buttons.add(nextButton, gbc);
//        center.add(buttons, BorderLayout.SOUTH);
////        previousButton.addActionListener(this);
////        nextButton.addActionListener(this);
////        pause.addActionListener(this);
////        playSlider.addChangeListener(this);
////        sound.setMinimum(0);
////        sound.setMaximum(65535);
////        sound.addChangeListener(this);
//
//    }
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
        addPlayList.setBounds(50, 100, 50, 100);
        addPlayList.addActionListener(this);
        jp2.add(playListLabel, BorderLayout.WEST);
        jp2.add(addPlayList, BorderLayout.EAST);
        gbcons.gridx = 0;
        gbcons.gridy = 1;
        northWest.add(jp2, gbcons);

        JLabel jlabel = new JLabel("Library");
        addLibrary = new JButton("+");
        addLibrary.setBounds(50, 100, 50, 100);
        addLibrary.addActionListener(this);
        jp.add(jlabel, BorderLayout.WEST);
        jp.add(addLibrary, BorderLayout.EAST);
        gbcons.gridx = 0;
        gbcons.gridy = 2;
        northWest.add(jp, gbcons);

        songs_button = new JButton("Songs");
        songs_button.setBounds(50, 100, 100, 100);
        gbcons.gridx = 0;
        gbcons.gridy = 3;
        northWest.add(songs_button, gbcons);
        songs_button.addActionListener(this);

        album_button = new JButton("Albums");
        album_button.setSize(new Dimension(50, 10));
        gbcons.gridx = 0;
        gbcons.gridy = 4;
        northWest.add(album_button, gbcons);
        album_button.addActionListener(this);

        westPanel.add(northWest, BorderLayout.NORTH);


        all_playlists_button = new JLabel("Playlist");
        all_playlists_button.setPreferredSize(new Dimension(200, 50));
        gbcons.gridx = 0;
        gbcons.gridy = 5;
        northWest.add(all_playlists_button, gbcons);
//        all_playlists_button.addActionListener(this);
        JPanel PlayLists = new JPanel();
        list = new JList();
        JScrollPane scrollableArea = new JScrollPane(list);
        scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollableArea,BorderLayout.WEST);
        list.setBounds(187, 51, 179, 167);
        setVisible(true);
        westPanel.add(list);
        westPanel.add(scrollableArea , BorderLayout.EAST);
        DLM = new DefaultListModel();
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

    public void setEastPanel() {
        JLabel jLabel = new JLabel();
        jLabel.setForeground(Color.CYAN);
        jLabel.setText(jLabel.getText() + "Friend Activity");
        //jLabel.add(button);

        GridBagConstraints gbcons = new GridBagConstraints();
        JLabel jLabel1 = new JLabel();
        jLabel.setBackground(Color.RED);
        eastPanel.add(jLabel);

        gbcons.fill = GridBagConstraints.VERTICAL;
        gbcons.gridx = 0;
        gbcons.gridy = 1;
        eastPanel.setBackground(Color.BLACK);


    }

    public void setCenterPanel() {
        centerPanel.setBackground(Color.MAGENTA);
        GridBagConstraints gbcons = new GridBagConstraints();
        //JLabel jLabel = new JLabel();
        //JScrollPane scrollableArea = new JScrollPane(centerPanel);
        //scrollableArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //centerPanel.add(scrollableArea,BorderLayout.EAST);
        //getContentPane().add(centerPanel,BorderLayout.CENTER);
        //centerPanel.setBounds(187, 51, 179, 167);
//        setVisible(true);
//        centerPanel.add(scrollableArea , BorderLayout.EAST);

    }


    public void drawSongs(ArrayList<Music> allSongs) {
        //pList.setListMusic(p.getListMusic());
        JButton b;
        songsButtonList.clear();
        centerPanel.removeAll();
        centerPanel.revalidate();
        centerPanel.repaint();
        setVisible(true);

//        for( int i=0; i < centerPanel.getComponentCount(); i++)
//            centerPanel.remove(i);
        for (int i = 0; i < allSongs.size(); i++) {
            b = new JButton(allSongs.get(i).getTitle());
            b.setIcon(allSongs.get(i).getIcon());
            b.setPreferredSize(new Dimension(160, 160));
            GridBagConstraints gbcons = new GridBagConstraints();
            gbcons.gridx = 0;
            gbcons.gridy = 0;


            //System.out.println(currentSong.getArtist());
            songsButtonList.add(b);
            b.addActionListener(this);
            JPanel jp = new JPanel();
            JLabel jTitle = new JLabel(allSongs.get(i).getTitle());
            jTitle.setBounds(0, 0, 50, 50);
            JLabel jArtist = new JLabel(allSongs.get(i).getArtist());
            jArtist.setBounds(0, 100, 50, 50);
            jp.add(b);
            jp.add(jTitle, gbcons);
            jp.add(jArtist, gbcons);

            centerPanel.add(jp);
        }
    }

    public void drawAlbums(ArrayList<Album> albums) {
        JButton g;
        albumButtonlist.clear();
        centerPanel.removeAll();
        centerPanel.revalidate();
        centerPanel.repaint();
        setVisible(true);

//        for( int i=0; i < centerPanel.getComponentCount(); i++)
//            centerPanel.remove(i);
        for (int i = 0; i < albums.size(); i++) {
            g = new JButton(albums.get(i).getName());
            g.setIcon(albums.get(i).getListMusic().get(0).getIcon());
            g.setPreferredSize(new Dimension(160, 160));
            GridBagConstraints gbcons = new GridBagConstraints();
            gbcons.gridx = 0;
            gbcons.gridy = 0;

            albumButtonlist.add(g);
            g.addActionListener(this);

            JPanel jp = new JPanel();
            JLabel jTitle = new JLabel(albums.get(i).getName());
            jTitle.setBounds(0, 0, 50, 50);
            jp.add(g);
            jp.add(jTitle, gbcons);

            centerPanel.add(jp);
        }
        setVisible(true);
        centerPanel.revalidate();

    }
//        for (int i = 0; i < allSongs.size(); i++) {
//            centerPanel.add(songsButtonList.get(i));
//        }



    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < songsButtonList.size(); i++) {
            if (e.getSource().equals(songsButtonList.get(i))) {

                if (type == 1) {
                    southPanel.setMusics(songs,i);

                    if (playing != null)
                        //playing.pause();
                        southPanel.pausePlaying(playing);
                    playing = songs.get(i);
                    //songs.get(i).play();
                    timeSorter(songs , i);

                    southPanel.startPlaying(0);
                    getContentPane().add(southPanel, BorderLayout.SOUTH);


                }

                else if (type == 2) {
                    southPanel.setMusics(playLists.get(list.getSelectedIndex()).getListMusic(),i);

                    if (playing != null)
//                        playing.pause();
                        southPanel.pausePlaying(playing);

                    playing = playLists.get(list.getSelectedIndex()).getListMusic().get(i);
                    //playLists.get(list.getSelectedIndex()).getListMusic().get(i).play();
                    timeSorter(playLists.get(list.getSelectedIndex()).getListMusic() , i);
                    playLists.get(list.getSelectedIndex()).setCurrentSong(i);

                    southPanel.startPlaying(0);
                    getContentPane().add(southPanel, BorderLayout.SOUTH);

                }
                if (type == 3) {
                    if (playing != null)
                        playing.pause();
                    playing = albums.get(currentAlbum).getListMusic().get(i);
                    albums.get(currentAlbum).getListMusic().get(i).play();
                    timeSorter(albums.get(currentAlbum).getListMusic() , i);
                }
                if (type == 4 ){
                    newPlayList.getListMusic().add(songs.get(i));
                }

            }
        }
        for (int i = 0; i < albumButtonlist.size(); i++) {
            if (e.getSource().equals(albumButtonlist.get(i))) {
                type = 3;
                currentAlbum = i;
                drawSongs(albums.get(i).getListMusic());

            }
        }

        if (e.getSource().equals(album_button)) {
            drawAlbums(albums);
        }
        if (e.getSource().equals(okPlayList)) {
            playLists.add(newPlayList);
            System.out.println(newPlayList.getName());
            DLM.addElement(newPlayList.getName());
            list.setModel(DLM);
            westPanel.add(list);
            setVisible(true);
        }



        if (e.getSource().equals(addPlayList)) {
            type = 4;
            drawSongs(songs);
            okPlayList = new JButton("Create");
            okPlayList.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playLists.add(newPlayList);
                    DLM.addElement(newPlayList.getName());
                    list.setModel(DLM);
                    westPanel.add(list);
                    setVisible(true);

                }
            });
            centerPanel.add(okPlayList);
            String s = String.format("P%d", playLists.size());
            newPlayList = new PlayList(s);
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
    public ArrayList<Music> timeSorter(ArrayList<Music> musics, int index){
        Music temp = musics.get(index);
        for(int i = index-1 ; i>=0 ; i--) {
            musics.set(i+1 , musics.get(i));

        }
        musics.set(0 , temp);
        return musics;
    }

}
