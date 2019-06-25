package GuiLogic;
import existances.Music;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class PlayingTimer extends Thread {
    private DateFormat dateFormater = new SimpleDateFormat("HH:mm:ss");
    private boolean isRunning = false;
    private boolean isPause = false;
    private boolean isReset = false;
    private long startTime;
    private long pauseTime;
    private JLabel labelRecordTime;
    private JLabel songLength;
    private JSlider slider;
    private existances.Music music;

    public PlayingTimer(JLabel labelRecordTime, JSlider slider) {
        this.labelRecordTime = labelRecordTime;
        this.slider = slider;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(existances.Music music) {
        this.music = music;

    }

    public void run() {
        isRunning = true;
        startTime = System.currentTimeMillis();

        while (isRunning) {
//            try {
//                Thread.sleep(100);
                if (!isPause) {
                    if (music != null && music.isRunning()) {
                        labelRecordTime.setText(toTimeString());
                        int currentSecond = (int) music.getPosition();
                        slider.setValue(currentSecond);
                    }
                }
//                } else {
                pauseTime += 100;
//                }
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
                if (isReset) {
                    slider.setValue(0);
                    labelRecordTime.setText("00:00:00");
                    isRunning = false;
                    break;
                }
//            }

        }
    }


    public void reset() {
        isReset = true;
        isRunning = false;
    }
   public void pauseTimer() {
        isPause = true;
    }

   public void resumeTimer() {
        isPause = false;
    }


    private String toTimeString() {
        long now = System.currentTimeMillis();
        Date current = new Date(now - startTime - pauseTime);
        dateFormater.setTimeZone(TimeZone.getTimeZone("GMT"));
        String timeCounter = dateFormater.format(current);
        return timeCounter;
    }
}
