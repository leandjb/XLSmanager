package com.example.manager;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteXlsFile {

    public void writeXls(String path, String sheetName, String[] dataToWrite) throws IOException {

        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

        XSSFRow row = newSheet.getRow(0);
        XSSFRow newRow = newSheet.createRow(rowCount + 1);

        for (int i = 0; i < row.getLastCellNum(); i++) {
            XSSFCell newCell = newRow.createCell(i);
            newCell.setCellValue(dataToWrite[i]);
        }

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);

        newWorkbook.write(outputStream);

        outputStream.close();
    }

    public void writeCellValue(String path, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {
        File file = new File(path);
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        XSSFRow row = newSheet.getRow(rowNumber);

        XSSFCell firstCell = row.getCell(cellNumber - 1);
        System.out.println("first cell value is:"+firstCell.getStringCellValue());

        XSSFCell nextCell = row.createCell(cellNumber);
        nextCell.setCellValue(resultText);

        System.out.println("next cell is:"+ nextCell.getStringCellValue());

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);
        newWorkbook.write(outputStream);
        outputStream.close();
    }
}
