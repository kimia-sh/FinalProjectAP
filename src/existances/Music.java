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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Music {
    JpotifyPlayer jpotifyPlayer;
    private String address;
    private InputStream musicStream;
    private String title;
    private String artist;
    private String album;
    public Music(String address)  {

        this.address=address;
        title=new String();
        artist=new String();
        album=new String();
        setMusicStream();
        jpotifyPlayer=new JpotifyPlayer(this);


    }
    private void setMusicStream(){


        try {
            musicStream = new FileInputStream(address);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }


    }


    public InputStream getMusicStream() {
        setMusicStream();
        return musicStream ;
    }
    // play from the first
    public void play(){

        if(!jpotifyPlayer.getState().name().equals("NEW")) {
            jpotifyPlayer.close();
            jpotifyPlayer=new JpotifyPlayer(this);
        }
        jpotifyPlayer.mp3Play();
    }
    public void pause(){
        jpotifyPlayer.mp3Pause();
    }
    public void resume(){
        jpotifyPlayer.mp3Resume();
    }
    public void seekto(int n){
        jpotifyPlayer.seekTo(n);
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

//    public static void main(String args[]){
//        Scanner scanner=new Scanner(System.in);
//        Music music=new Music("E://musics/t.mp3");
//
//
////             int i=0;
////
////
////
////        while( i!=1){
////            if(i==3)
////            music.play();
////            if(i==2)
////                music.pause();
////            if(i==4)
////                music.resume();
////            if(i==5)
////                music.seekto(1000);
////
////
////            i=scanner.nextInt();
////        }
//
//            music.artWork();
//        System.out.println(music.getAlbum());
//        System.out.println( music.getArtist());
//        System.out.println(music.getTitle());
//    }

    
}
