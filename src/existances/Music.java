package existances;
import com.mpatric.mp3agic.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class Music extends Mp3File implements Serializable {
    JpotifyPlayer jpotifyPlayer;

    private String address;
    private InputStream musicStream;
    private String title;
    private String artist;
    private String album;
    private  Icon musicImage;
    public Music (){
        title=new String();
        artist=new String();
        album=new String();
        musicImage = new ImageIcon("E://pic.jpg");

    }
    public Music(String address, String title)  {
        if (this.hasId3v2Tag())
        {
            ID3v2 id3v2 = this.getId3v2Tag();
            byte[] imageData = id3v2.getAlbumImage();
            try {
                if (imageData != null) {
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
                    musicImage = new ImageIcon(img);
                }
            }catch(IOException io) {}
        }

        this.address=address;
        this.title = title;
        artist=new String();
        album=new String();
        setMusicStream();
        jpotifyPlayer=new JpotifyPlayer(this);
        musicImage = new ImageIcon("E://pic.jpg");


    }

    public void setAddress(String address) {
        this.address = address;
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

    public Icon getIcon() {
        return musicImage ;
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
    public void seekTo(int second){
        jpotifyPlayer.seekTo((int) Math.round((float)second *(38.46)));
    }
    public void close(){
        jpotifyPlayer.close();
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


    public Boolean isRunning(){
        return( !jpotifyPlayer.getPause());
    }
    public long getPosition(){
        long position=(Math.round((float)jpotifyPlayer.getCurrentFrame()/(38.46))) ;
        return position;

    }
    public long getMusicSecondLength(){
        long musicSecondLength;
        try {
            byte[] bytes=getMusicStream().readAllBytes();
            musicSecondLength =Math.round(bytes.length*8/320000);
        } catch (IOException e) {
            e.printStackTrace();
            musicSecondLength=0;
        }

        return musicSecondLength;
    }
    public String getMusicLengthString() {
        String length = "";
        long hour = 0;
        long minute = 0;
        long seconds = getMusicSecondLength() ;

        System.out.println(seconds);

        if (seconds >= 3600) {
            hour = seconds / 3600;
            length = String.format("%02d:", hour);
        } else {
            length += "00:";
        }

        minute = seconds - hour * 3600;
        if (minute >= 60) {
            minute = minute / 60;
            length += String.format("%02d:", minute);

        } else {
            minute = 0;
            length += "00:";
        }

        long second = seconds - hour *3600 - minute * 60;

        length += String.format("%02d", second);

        return length;
    }


    public static void main(String args[]){
//        Scanner scanner=new Scanner(System.in);
//        Music music=new Music("E://1.mp3");
//        System.out.println(music.getMusicLengthString());
//
//
//             int i=0;
//
//
//
//        while( i!=1){
//            if(i==3)
//            music.play();
//            if(i==2)
//                music.pause();
//            if(i==4)
//                music.resume();
//            if(i==5)
//                music.seekTo(40);
//
//
//            i=scanner.nextInt();
//        }
//
//            music.artWork();
//        System.out.println(music.getAlbum());
//        System.out.println( music.getArtist());
//        System.out.println(music.getTitle());
    }


}
