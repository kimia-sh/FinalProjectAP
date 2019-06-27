package existances;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.io.*;

public class PlayList  extends BaseOfAlbumAndPlaylist implements Serializable {
    private String address;
    File file;

    public PlayList(String name) {
        super(name);
        String address="E://ap/Project/FinalProjectAP/library/playlists/" + name +".txt";
         file = new File(address);
         save();

    }
    public void remove(Music music){
        getListMusic().remove(music);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void save() {

        try {
            file.getParentFile().mkdirs();

                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(this);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("23");
        }

    }
    public static void main(String args[]){
//        PlayList playList=new PlayList("favorite");
//        Music music=new Music("E://musics/o.mp3");
//        playList.add(music);
//        playList.save();

    }
}
