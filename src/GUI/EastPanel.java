package GUI;

import javax.swing.*;
import java.awt.*;

public class EastPanel extends JPanel {
    public EastPanel(){
        //JButton button = new JButton("increase me");
        //setBounds(200, 200, 100, 100);
        JLabel jLabel = new JLabel();
        jLabel.setForeground(Color.CYAN);
        jLabel.setText(jLabel.getText()+"Friend Activity");
        //jLabel.add(button);

        GridBagConstraints gbcons = new GridBagConstraints();
            JLabel jLabel1 = new JLabel();
            jLabel.setBackground(Color.RED);
        add(jLabel);
//        JButton b1=new JButton();
//        gbcons.fill = GridBagConstraints.HORIZONTAL;
//        gbcons.gridx = 0;
//        gbcons.gridy = 1;
//        b1.setBackground(Color.yellow);
//        b1.setPreferredSize(new Dimension(100 , 100));
//        add(b1);
        //jLabel.setText(jLabel.getText()+"Name " +
          //      " artWork " +
            //    " SongName");
        //jpanel1.add(jLabel);
        //jpanel1.setForeground(Color.BLUE);
        //jpanel1.setPreferredSize(new Dimension(350, 190));

        gbcons.fill = GridBagConstraints.VERTICAL;
            gbcons.gridx = 0;
            gbcons.gridy = 1;
        setBackground(Color.BLACK);
        setVisible(true);
    }
}
