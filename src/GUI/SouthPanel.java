package GUI;

import javax.swing.*;
import java.awt.*;

public class SouthPanel {
    public static void main(String[] args) {
        JFrame f = new JFrame();f.getContentPane().setLayout(new BorderLayout());
        JPanel mainSouthPanel = new JPanel();
        FlowLayout slay = new FlowLayout();mainSouthPanel.setLayout(slay);

        JButton previosButton = new JButton("<");

        JButton nextButton = new JButton("||");

        JButton pause = new JButton(">");

        mainSouthPanel.add(previosButton,FlowLayout.LEFT);
        mainSouthPanel.add(nextButton,FlowLayout.CENTER);mainSouthPanel.add(pause,FlowLayout.RIGHT);
        f.add( mainSouthPanel, BorderLayout.SOUTH);

        f.setSize(300,300);
        f.setVisible(true);
    }
}
