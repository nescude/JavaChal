package com.nescude.Utils;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TreeMap;

public class LogAnalyser {

    static TreeMap<String,Integer> map = new TreeMap<>();

    public static TreeMap<String,Integer> analyse(ArrayList<String> list){

    String lastUser=null;
    String sequence=null;
    int sequenceLong=-1;

        for (String loggedEvent : list){
            String user = getUser(loggedEvent);
            int page    = getPage(loggedEvent);

            if (!user.equals(lastUser)){
                lastUser       = user;
                sequence        = "page_"+page+",";
                sequenceLong   = 1;
            }
            else{
                if (sequenceLong == 2){
                    sequence= sequence.concat("page_"+page+"");
                    if (map.get(sequence)!=null)
                        map.put(sequence,map.get(sequence)+1);
                    else
                        map.put(sequence,1);
                    sequence = sequence.split(",")[1]+","+sequence.split(",")[2]+",";
                }
                else{
                    sequenceLong++;
                    sequence = sequence.concat("page_"+page+",");
                }
            }
        }
        return map;
    }

    private static String getUser(String loggedEvent){
        return loggedEvent.split(";")[0].toUpperCase(Locale.ROOT);
    }

    private static int getPage(String loggedEvent){
        return Integer.parseInt(loggedEvent.split(";")[2].split("_")[1]);
    }
}
