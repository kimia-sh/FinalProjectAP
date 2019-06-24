package existances;
import com.mpatric.mp3agic.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import javax.swing.*;
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
    private  Icon musicImage;
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
            ID3v2 id3v2 =myMusic.getId3v2Tag();


            title=id3v2.getTitle();
            artist=id3v2.getArtist();
            album=id3v2.getAlbum();
            id3v2.getAlbumImage();

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
