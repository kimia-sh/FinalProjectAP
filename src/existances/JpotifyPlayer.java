package existances;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.awt.*;
import java.io.Serializable;

public class JpotifyPlayer extends Thread implements Serializable {
    Music music;
    AdvancedPlayer player;
    Boolean isPause;
    int currentFrame;
    public JpotifyPlayer(Music music){
        currentFrame=0;
        this.music = music;
        try {
            player=new AdvancedPlayer(music.getMusicStream());
        } catch (JavaLayerException e) {
            e.printStackTrace();
            System.out.println("1");
        }



        isPause=false;

    }

    @Override
    public void run() {
        boolean playing=true;
        while(playing){
            if((isPause)){
                synchronized (player) {
                    try {
                        player.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("3");
                    }
                }

            }
            else {
                try {
                    playing = player.play(1);
                    currentFrame++;
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                    System.out.println("2");
                    playing = false;
                }
            }
        }

    }
    public void mp3Pause(){
        this.isPause=true;
    }
    public void mp3Resume(){
        this.isPause=false;
        synchronized (player){
            player.notifyAll();
        }

    }
    public void mp3Play(){
        this.start();
    }
    public void seekTo(int frame){
        synchronized (player){
            player.close();
            try {
                player=new AdvancedPlayer(music.getMusicStream());
            } catch (JavaLayerException e) {
                e.printStackTrace();
                System.out.println("6");

            }
            try {
                player.play(frame,frame+1);
            } catch (JavaLayerException e) {
                e.printStackTrace();
                System.out.println("7");
            }
        }
    }
    public void close(){
        this.suspend();

    }

    public Boolean getPause() {
        return isPause;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }
}
