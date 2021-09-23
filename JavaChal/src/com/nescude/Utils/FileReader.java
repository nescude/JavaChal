package com.nescude.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    protected static final String FILE_NAME = "users.log";
    static Scanner sc;

    public static ArrayList<String> getText(String fName){
        ArrayList<String> logs = new ArrayList<>();
        URL url = FileReader.class.getResource(fName);

        if (url != null){
            try{
                File file = new File(url.getPath());
                sc = new Scanner(file);
            }
            catch (FileNotFoundException e){
                return null;
            };

            while (sc.hasNext()){
                logs.add(sc.next());
            }
            sc.close();
            return logs;
        }
        else
            return null;
    }

    public static ArrayList<String> getText(){
        return getText(FILE_NAME);
    }
}
