package GUI;

import javax.swing.*;
import java.awt.*;

public class NorthPanel {
    public static void main(String args[]) {
        JFrame f = new JFrame();
        f.getContentPane().setLayout(new BorderLayout());
        JTextArea area = new JTextArea(1, 20);
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        JButton search = new JButton("Search");
        jp.add(search, BorderLayout.WEST);
        jp.add(area, BorderLayout.CENTER);
        f.setSize(300, 300);
        f.getContentPane().add(jp, BorderLayout.NORTH);
        f.setVisible(true);
    }
}
