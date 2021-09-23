package com.nescude.UtilsTests;

import com.nescude.Utils.MapSorter;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MapSorterTest {

    @Test
    public void sortByValuesTest(){
        Map<String,Integer> actual = new HashMap<>();
        actual.put("c",5);
        actual.put("d",1);
        actual.put("e",7);
        actual.put("f",3);

        Map<String,Integer> treeCorrect = new LinkedHashMap<>();
        treeCorrect.put("e",7);
        treeCorrect.put("c",5);
        treeCorrect.put("f",3);
        treeCorrect.put("d",1);

        Map<String,Integer> treeIncorrect = new LinkedHashMap<>();

        treeIncorrect.put("d",1);
        treeIncorrect.put("f",3);
        treeIncorrect.put("c",5);
        treeIncorrect.put("e",7);


        List<Map.Entry<String,Integer>> expected = new ArrayList<>(treeCorrect.entrySet());

        assertEquals(expected,MapSorter.SortByValues(actual));

        expected = new ArrayList<>(treeIncorrect.entrySet());

        assertNotEquals(expected,MapSorter.SortByValues(actual));
    }
}
