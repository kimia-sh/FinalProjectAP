package GUI;


import existances.Music;
import existances.SoundMaster;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SouthPanel  extends JPanel implements ActionListener, ChangeListener {
    private GuiLogic.PlayingTimer timer;
    private Thread playThread;
    private SoundMaster soundMaster=new SoundMaster();

    private boolean isPlaying = false;
    private boolean isPause = false;
    private Music music=new Music();
    BorderLayout borderLayout;
    JPanel west;
    JPanel center;
    JPanel east;
    JButton previousButton ;
    JButton nextButton ;
    JButton pause ;
    JLabel title;
    JLabel artist ;
    JLabel album ;
    JSlider playSlider;
    JSlider sound ;
    JLabel passedTime;
    JLabel time;
    public SouthPanel(){
        east=new JPanel(new BorderLayout());
        west=new JPanel();
        center=new JPanel();
        borderLayout=new BorderLayout();
        previousButton = new JButton("<");
        nextButton = new JButton(">");
        pause = new JButton("||");
        title=new JLabel("title");
        title.setSize(new Dimension(50,100));
        artist =new JLabel("artist");
        album =new JLabel("album");
        playSlider=new JSlider();
        sound = new JSlider();
        passedTime=new JLabel("passed time");
        time=new JLabel("                                 "+"time");

        setLayout(borderLayout);
        add(west,BorderLayout.WEST);
        add(center,BorderLayout.CENTER);
        add(east,BorderLayout.EAST);
        east.add(sound,BorderLayout.CENTER);
        west.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        gbc.gridwidth=3;
        gbc.gridx=0;
        gbc.gridy=0;
        west.add(title,gbc);
        gbc.gridy=1;
        west.add(artist,gbc);
        gbc.gridy=2;
        west.add(album,gbc);
        center.setLayout(new BorderLayout(10,0));
        center.add(time,BorderLayout.EAST);
        center.add(passedTime,BorderLayout.WEST);
        center.add(playSlider,BorderLayout.CENTER);
        JPanel buttons=new JPanel(new GridBagLayout());
        gbc.gridy=0;
        gbc.gridx=12;
        buttons.add(previousButton,gbc);
        gbc.gridx=16;
        buttons.add(pause,gbc);
        gbc.gridx=20;
        buttons.add(nextButton,gbc);
        center.add(buttons,BorderLayout.SOUTH);
        previousButton.addActionListener(this);
        nextButton.addActionListener(this);
        pause.addActionListener(this);
        playSlider.addChangeListener(this);
        sound.setMinimum(0);
        sound.setMaximum(65535);
        sound.addChangeListener(this);




    }
    /**
     * Handle click events on the buttons.
     */


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            if(button==pause){

                if(!isPlaying )
                    startPlaying(0);
                 else {
                    if (isPlaying && !isPause)
                        pausePlaying();
                    else {
                        if (isPlaying && isPause)
                            resumePlaying();
                    }
                }

            }
        }

    }
    private void startPlaying(int second) {
        timer = new GuiLogic.PlayingTimer(passedTime, playSlider);
//        timer.start();
        isPlaying = true;
        if(playThread != null)
            playThread.interrupt();
        playThread = new Thread(new Runnable() {

            @Override
            public void run() {
                music.setAddress("E://musics/t.mp3");
                timer.setMusic(music);
                music.artWork();
                title.setText(music.getTitle()+"                              ");
                artist.setText(music.getArtist()+ "                              ");
                album.setText(music.getAlbum()+ "                              ");
                playSlider.setMaximum((int) music.getMusicSecondLength());

                time.setText(music.getMusicLengthString(1));
                if(second==0)
                   music.play();
                else
                    music.seekTo(second);
                timer.runPlayingTimer();
//                resetControls();
                // for the time its completing
            }

        });
        System.out.println(playThread.getState());
        playThread.start();
//        System.out.println(playThread.getState());
//        playThread.run();
//        System.out.println(playThread.getState());

    }
    private void pausePlaying() {

        isPause = true;
        music.pause();
        timer.pauseTimer();
        playThread.interrupt();
    }

    private void resumePlaying() {

        isPause = false;
        music.resume();
        timer.resumeTimer();
        playThread.interrupt();
    }
    private void resetControls() {
        timer.reset();
//        timer.interrupt();
        isPlaying = false;
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        Object source = e.getSource();
        if(source instanceof JSlider){
            JSlider slider = (JSlider) source;
            if(slider==playSlider){
                long lastposition=music.getPosition();
                int second=slider.getValue();
                System.out.println(second);
                System.out.println(lastposition);
//                if(Math.abs(lastposition-(long)second)>1 && !(second==50 && lastposition==0))
                if(!(second==lastposition) && !(lastposition==0))
                 startPlaying(second);


            }
            else{
                if(slider==sound){
                   int volume=slider.getValue();
                   soundMaster.setVolume(volume);
                }
            }
        }
    }
//    public void seek(int second){
//
//
//        music.close();
//        playThread.interrupt();
//        music=new Music();
//        music.setAddress("E://musics/t.mp3");
//        music.seekTo(second);
//
//
////        playThread = new Thread(new Runnable() {
////
////            @Override
////            public void run() {
////
//////                timer.seek(music,second);
////            }
////
////        });
//////        playThread.start();
////        playThread.start();
//
//    }
}
