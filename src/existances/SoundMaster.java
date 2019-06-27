package existances;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SoundMaster {
    public SoundMaster(){
        setVolume(0);

    }
    public void setVolume(Integer volume){

        ProcessBuilder processBuilder=new ProcessBuilder("nircmd.exe","setsysvolume",volume.toString());
        System.out.println(processBuilder.command());
        processBuilder.directory(new File("C://Users/ASUS"));
        try {
            Process pro = processBuilder.start();
            pro.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}