package com.project.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelInit {


    private String fileFullPath;
    private String excelName;
    private String sheetName;
    private String dataTableName;
    private String columnHeader;

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;


    public ExcelInit(String fileFullPath, String sheetName) throws IOException {

        this.fileFullPath = fileFullPath;
        this.excelName = excelName;
        this.sheetName = sheetName;

        initExcelDetails(fileFullPath, sheetName);
    }


    private void initExcelDetails(String fileFullPath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(fileFullPath);
        this.workbook = new XSSFWorkbook(fis);
        this.sheet = workbook.getSheet(sheetName);
    }


    public XSSFSheet getSheetObj() {
        return sheet;
    }

    public XSSFWorkbook getworkbookObj() {
        return workbook;
    }

    public String getFileFullPath() {
        return fileFullPath;
    }


    public String getExcelName() {
        return excelName;
    }


    public String getSheetName() {
        return sheetName;
    }


    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }


    public String getDataTableName() {
        return dataTableName;
    }


    public void setDataTableName(String dataTableName) {
        this.dataTableName = dataTableName;
    }


    public String getColumnHeader() {
        return columnHeader;
    }


    public void setColumnHeader(String columnHeader) {
        this.columnHeader = columnHeader;
    }

}
