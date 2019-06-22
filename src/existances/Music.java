package existances;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import com.mpatric.mp3agic.Mp3File;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Music {
    private Thread thread;

    private String address;
    private InputStream musicStream;
    private AdvancedPlayer player;
    private String title;
    private String artist;
    private String album;
    private Runnable r;

    private long end;
    private long start;
    private long passedTime;
    private long length;
    //    private int pausedOnFrame = 0;
    public Music(String address)  {

        this.address=address;
        title=new String();
        artist=new String();
        album=new String();

        end=0;
        start=0;
        passedTime=0;
        setMusicStream();

        setPlayer();

       r = new Runnable( ) {
            public void run() {

                    if (passedTime == 0) {
                        try {
                            player.play();

                        } catch (JavaLayerException e) {
                            System.out.println("Error");
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            player.play((int) passedTime);
                        } catch (JavaLayerException e) {
                            e.printStackTrace();
                        }
                    }
                }

        };
        thread=new Thread(r);


//        player.setPlayBackListener(new PlaybackListener() {
//            @Override
//            public void playbackFinished(PlaybackEvent event) {
//                pausedOnFrame = event.getFrame();
//            }
//        });


    }
    private void setMusicStream(){

        try {
            musicStream = new FileInputStream(address);
            try {
                Mp3File t=new Mp3File(address);
                length=t.getLengthInMilliseconds();
            } catch (UnsupportedTagException e) {
                e.printStackTrace();
            } catch (InvalidDataException e) {
                e.printStackTrace();
            }


        }

        catch (IOException e){
            System.out.println("ERROR");

        }

    }


    private void setPlayer() {
        try {
            player=new AdvancedPlayer(musicStream);

        }
        catch (JavaLayerException e){
            // showing proper message
            System.out.println("ERROR");
            e.printStackTrace();
        }

    }

    public void play(){

        if(!thread.getState().name().equals("NEW"))
            thread=new Thread(r);
        System.out.println(thread.getState());
        setMusicStream();
        setPlayer();

        thread.start();

        start=System.currentTimeMillis();

    }
//    public void play(int startPoint){
//        passedTime=startPoint;
//        System.out.println(thread.getState());
//        thread.start();
//
//    }
    public void stop(){
        thread.stop();
        player.close();

        System.out.println(thread.getState());
        end =System.currentTimeMillis();
        passedTime+=end-start;

    }



    public void artWork(){
        try {
            Mp3File myMusic=new Mp3File(address);
            ID3v1 id3v1Tag = myMusic.getId3v1Tag();

            title=id3v1Tag.getTitle();
            artist=id3v1Tag.getArtist();
            album=id3v1Tag.getAlbum();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR");
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
            System.out.println("ERROR");

        } catch (InvalidDataException e) {
            e.printStackTrace();

        }


    }

    public String  getAlbum() {
        return album;

    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public static void main(String args[]){
             int i=0;
        Scanner scanner=new Scanner(System.in);

            Music music = new Music("E://musics/o.mp3");
        while( i!=1){
            if(i==3)
            music.play();
            if(i==2)
                music.stop();


            i=scanner.nextInt();
        }

            music.artWork();
        System.out.println(music.getAlbum());
        System.out.println( music.getArtist());
        System.out.println(music.getTitle());
    }

    
}
