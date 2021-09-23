package com.nescude.UtilsTests;

import com.nescude.Utils.FileReader;
import com.nescude.Utils.LogAnalyser;
import org.junit.Test;

import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LogAnalyserTest {

    @Test
    public void analyseTest(){
        Map<String,Integer> map = LogAnalyser.analyse(Objects.requireNonNull(FileReader.getText("test1.log")));
        assertNotNull(map);
        assertEquals(4,map.size());
    }
}
