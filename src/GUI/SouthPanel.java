package GUI;

<<<<<<< HEAD

=======
>>>>>>> 1b1245d2a485219ad9fc610f320632d20c1e0486
import existances.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.io.IOException;

public class SouthPanel  extends JPanel implements ActionListener {
    private GuiLogic.PlayingTimer timer;
    private Thread playThread;

    private boolean isPlaying = false;
    private boolean isPause = false;
    private Music music=new Music();
=======

public class SouthPanel  extends JPanel implements ActionListener {
>>>>>>> 1b1245d2a485219ad9fc610f320632d20c1e0486
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
        ImageIcon icone;
        //Music music = new Music();
        public SouthPanel(){
            east=new JPanel(new BorderLayout());
            //icone = new ImageIcon("D:\\n.png");
//            west = new WestPanel();
            west =new JPanel();
            center=new JPanel();
            borderLayout=new BorderLayout();
            previousButton = new JButton();
            previousButton.setIcon(icone);
            previousButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            } );
            nextButton = new JButton(">");
            nextButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {


                }
            } );
            pause = new JButton("||");
            pause.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {


                }
            } );
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
            center.add(time,BorderLayout.WEST);
            center.add(passedTime,BorderLayout.EAST);
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




        }
    /**
     * Handle click events on the buttons.
     */


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
//            if (button == buttonOpen) {
//                openFile();
//            if (button == pause) {
//                if (!isPlaying) {
//                    playBack();
//                } else {
//                    stopPlaying();
//                }
//            } else if (button == buttonPause) {
//                if (!isPause) {
//                    pausePlaying();
//                } else {
//                    resumePlaying();
//                }
//            }

              if(button==pause){
//                  if(isPlaying){
//                      pausePlaying();
//                  }
//                  else{
//                      if(isPause)
//                          resumePlaying();
//                      else{
//                          startPlaying();
//                      }
//                  }
                  if(!isPlaying )
                      startPlaying();
                  if(isPlaying && !isPause)
                      pausePlaying();
                  if(isPlaying && isPause)
                      resumePlaying();

              }
        }

    }
    private void startPlaying() {
        timer = new GuiLogic.PlayingTimer(passedTime, playSlider);
        timer.start();
        isPlaying = true;
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

                time.setText(music.getMusicLengthString());
                music.play();
//                resetControls();
                     // for the time its completing
            }

        });
        playThread.start();
    }
    private void pausePlaying() {

        isPause = true;
        music.pause();
        timer.pauseTimer();
        playThread.interrupt();
    }

    private void resumePlaying() {

<<<<<<< HEAD
        isPause = false;
        music.resume();
        timer.resumeTimer();
        playThread.interrupt();
    }
    private void resetControls() {
        timer.reset();
        timer.interrupt();
        isPlaying = false;
=======
    @Override
    public void actionPerformed(ActionEvent e) {

>>>>>>> 1b1245d2a485219ad9fc610f320632d20c1e0486
    }
}
