package com.project.excelpoc;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelPojo {

    private String filePath;
    private XSSFWorkbook workBook;
    private XSSFSheet toggleSheet;
    private XSSFSheet paramSheet;
    FileInputStream fis;

    public ExcelPojo(String filePath, String toggleSheet, String paramSheet) throws IOException {

        this.filePath = filePath;

        if (!(null == filePath)) {
            fis = new FileInputStream(filePath);
            this.workBook = new XSSFWorkbook(fis);
        }

        if (!(null == toggleSheet)) {
            //this.toggleSheet = workBook.getSheet(toggleSheet);
            this.toggleSheet = getSheet(toggleSheet);
        }

        if (!(null == paramSheet)) {
            this.paramSheet = workBook.getSheet(paramSheet);
        }


    }

    public FileInputStream getInputFileObject(){
        return fis;
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
                this.toggleSheet = workBook.getSheet("Toggles");
                if (toggleSheet.getLastRowNum() == 0) {
                    this.toggleSheet.createRow(0).createCell(0).setCellValue("TOGGLES");
                }
                return toggleSheet;
            } else {
                this.toggleSheet = workBook.createSheet("Toggles");
                toggleSheet.createRow(0).createCell(0).setCellValue("TOGGLES");
                return toggleSheet;
            }

        } else if (sheetName.equalsIgnoreCase("Param") || sheetName.equalsIgnoreCase("params")
                || sheetName.equalsIgnoreCase("parameters")) {

            if (!(workBook.getSheet("Parameters") == null)) {
                this.paramSheet = workBook.getSheet("Parameters");
                if(paramSheet.getLastRowNum() == 0){
                    this.paramSheet.createRow(0).createCell(0).setCellValue("PARAMETERS");
                }
                return paramSheet;
            } else {
                this.paramSheet = workBook.createSheet("Parameters");
                paramSheet.createRow(0).createCell(0).setCellValue("PARAMETERS");
                return paramSheet;
            }

        } else {
            return null;
        }
    }


}
