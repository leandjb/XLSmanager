package com.example.manager;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ReadXlsTest {

    private WriteXlsFile writeFile;
    private ReadXlsFile readFile;

    @Before
    public void setUp(){
        readFile = new ReadXlsFile();
    }

    @Test
    public void doReadFile() throws IOException {
        String path = "src/main/resources/utils/gas_precios.xlsx";

        String searchText = readFile.getCellXls(path,"Sheet1",0,0);
        System.out.println("######## "+ searchText);

        String searchText2 = readFile.readXls(path,"Sheet1");
        System.out.println("######## "+ searchText2);

    }
}
