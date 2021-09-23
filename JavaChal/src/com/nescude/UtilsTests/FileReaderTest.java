package com.nescude.UtilsTests;

import com.nescude.Utils.FileReader;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class FileReaderTest {

    @Test
    public void testWrongFile(){
        assertNull(FileReader.getText("Badname.log"));
    }

    @Test
    public void testCorrectFile(){
        assertNotNull(FileReader.getText());
    }
}
