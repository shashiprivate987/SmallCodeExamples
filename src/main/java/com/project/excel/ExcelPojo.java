package com.project.excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelPojo {

    private String filePath;
    private XSSFWorkbook workBook;
    private XSSFSheet toggleSheet;
    private XSSFSheet paramSheet;

    public ExcelPojo(String filePath, String toggleSheet, String paramSheet) throws IOException {

        this.filePath = filePath;

        if (!(null == filePath)) {
            FileInputStream fis = new FileInputStream(filePath);
            this.workBook = new XSSFWorkbook(fis);
        }

        if (!(null == toggleSheet)) {
            this.toggleSheet = workBook.getSheet(toggleSheet);
        }

        if (!(null == paramSheet)) {
            this.paramSheet = workBook.getSheet(paramSheet);
        }


    }

    public String getFilePath() {
        return filePath;
    }

    public XSSFWorkbook getWorkbook() {
        return workBook;
    }

    public XSSFSheet getSheet(String sheetName) {

        if (sheetName.equalsIgnoreCase("Toggle") || sheetName.equalsIgnoreCase("Toggles")) {

            if (!(workBook.getSheet("Toggles") == null)) {
                return toggleSheet;
            } else {
                this.toggleSheet = workBook.createSheet("Toggles");
                return toggleSheet;
            }

        } else if (sheetName.equalsIgnoreCase("Param") || sheetName.equalsIgnoreCase("params")
                || sheetName.equalsIgnoreCase("parameters")) {

            if (!(workBook.getSheet("Parameters") == null)) {
                return paramSheet;
            } else {
                this.paramSheet = workBook.createSheet("Parameters");
                return paramSheet;
            }

        } else {
            return null;
        }

    }


}
