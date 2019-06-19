package existances;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;

import java.io.FileInputStream;
import java.io.InputStream;
public class Music {
    private String address;
    private InputStream musicStream;
    private Player player;
    public Music(String address)  {
        this.address=address;
        try {
            musicStream = new FileInputStream(address);


        }
        catch (IOException e){
            System.out.println("ERROR");

        }
        try {
            player=new Player(musicStream);
        }
        catch (JavaLayerException e){
            // showing proper message
            System.out.println("ERROR");
        }
    }
    public void play(){
        try {
            player.play();
        }
        catch(JavaLayerException e){
            System.out.println("ERROR");
        }
    }
    public static void main(String args[]){

            Music music = new Music("E://s.mp3");
            music.play();
 


    }

    
}
