package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class FirstPage extends JFrame implements ActionListener {
    JButton start;
    JTextArea ips;
    JTextArea clientUsername;
    boolean open = false;

    public FirstPage() {
        setSize(1366, 730);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JPanel mainPanel = (JPanel) getContentPane();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel title = new JLabel("please fill blanks to get start");
        title.setSize(new Dimension(100, 100));
//        title.setFont(new Font(""));
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(title, gbc);
        JLabel username = new JLabel("username");
        gbc.gridy = 1;
        mainPanel.add(username, gbc);
        clientUsername = new JTextArea(1, 15);
        clientUsername.setBackground(Color.WHITE);
        gbc.gridy = 2;
        mainPanel.add(clientUsername, gbc);
        JLabel ipLable = new JLabel("IP of your friends(every friend in a row)");
        gbc.gridy = 3;
        mainPanel.add(ipLable, gbc);
        ips = new JTextArea(7, 15);

        gbc.gridy = 4;
        mainPanel.add(ips, gbc);
        start = new JButton("start");
        gbc.gridy = 5;
        start.addActionListener(this);
        mainPanel.add(start, gbc);

//        for(int i=0;i<7;i++){
//            JTextArea ip=new JTextArea();
//
//            ip.setColumns(20);
//            ip.setBackground(Color.white);
//            ips.add(ip);
//        }
//        gbc.gridy=4;
//        for (JTextArea j: ips){
//
//            mainPanel.add(j);
//        }

        setVisible(true);
    }

    public boolean openProgram() {
        return open;
    }

    public void closeFirstPage() {
    setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            if (button.equals(start)) {
                File informatino = new File("E://ap/Project/FinalProjectAP/File/information.txt");
                informatino.getParentFile().mkdirs();

                    try {
                        informatino.createNewFile();
                        String username = clientUsername.getText();
                        FileWriter fileWriter = new FileWriter("E://ap/Project/FinalProjectAP/File/information.txt");
                        fileWriter.write(username +" ");
                        fileWriter.write(ips.getText());
                        fileWriter.close();
                        closeFirstPage();
                        super.dispose();
                        GUI gui = new GUI();
                        open = true;
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }


//                FileOutputStream fileOutputStream = null;
//                try {
//                    fileOutputStream = new FileOutputStream(informatino);
//                    ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
////                    objectOutputStream.writeObject(this);
//                    objectOutputStream.writeByte();
//                } catch (FileNotFoundException e1) {
//                    e1.printStackTrace();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//
//
//                }

                }
            }
        }
//    public static void main(String args[]){
//        FirstPage firstPage=new FirstPage();
//    }

    }

