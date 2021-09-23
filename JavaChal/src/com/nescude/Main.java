package com.nescude;
import com.nescude.Utils.FileReader;
import com.nescude.Utils.LogAnalyser;
import com.nescude.Utils.MapSorter;
import com.nescude.Utils.Messager;

import java.util.*;

public class Main {

    protected static final int TRIPLETS_TO_SHOW=10;

    public static void main(String[] args) {

        ArrayList<String> logList = FileReader.getText();

        if (logList != null){
            TreeMap<String,Integer> map = LogAnalyser.analyse(logList);
            List<Map.Entry<String,Integer>> sorted = MapSorter.SortByValues(map);
            int i=0;

            while (i<TRIPLETS_TO_SHOW && i<sorted.size()){
                Messager.printTriplet(sorted.get(i).getKey(),sorted.get(i).getValue());
                i++;
            }
        }
        else
            Messager.showError();
    }
}
