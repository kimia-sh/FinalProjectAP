package GUI;

import javax.swing.*;
import java.awt.*;

public class SouthPanel  extends JPanel{
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
        public SouthPanel(){
            east=new JPanel(new BorderLayout());
            west=new JPanel();
            center=new JPanel();
            borderLayout=new BorderLayout();
            previousButton = new JButton("<");
            nextButton = new JButton(">");
            pause = new JButton("||");
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
        }


}
