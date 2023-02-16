package com.techelevator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    public static FileWriter fWriter;
    public static String fileName;
    public static File file;
    static{
        fileName="Log.txt";
        file=new File(fileName);
        try {
            fWriter=new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String txt){

    }

}
