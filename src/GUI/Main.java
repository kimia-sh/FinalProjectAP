package GUI;

import existances.Music;
import existances.PlayList;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File information = new File("E://ap/Project/FinalProjectAP/File/information.txt");

        if (!information.exists()) {
            FirstPage firstPage = new FirstPage();
        }

        else {
            GUI gui=new GUI();
            }

        }
    }