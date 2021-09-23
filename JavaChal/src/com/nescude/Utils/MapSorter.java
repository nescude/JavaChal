package com.nescude.Utils;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapSorter {

    public static List<Map.Entry<String, Integer>> SortByValues(Map<String,Integer> map) {
        List<Map.Entry<String, Integer>> sorted = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        sorted.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return sorted;
    }
}
