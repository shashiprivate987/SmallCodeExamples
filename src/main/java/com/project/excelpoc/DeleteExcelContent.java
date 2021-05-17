package com.project.excelpoc;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DeleteExcelContent {

    private static ExcelPojo initExcel =null;
    private static FileOutputStream fileOut;

    public static void main(String[] args) throws IOException {

        //initExcel = new ExcelPojo(Constants.FILEPATH, Constants.TOGGLE_SHEET_NAME, Constants.PARAMETER_SHEET_NAME);
        String sheetName = "Toggles";
        String sheetParam = "Parameters";
        deleteAllRows(sheetName);
        deleteAllRows(sheetParam);
        //deleteAllSheet(sheetName);
    }

    private static void deleteAllSheet(String sheetName) throws IOException {
        int sheetNum = initExcel.getWorkbook().getSheetIndex(sheetName);
        initExcel.getWorkbook().removeSheetAt(sheetNum);
        initExcel.getInputFileObject().close();
        writeIntoFile();
    }

    private static void deleteAllRows(String sheetName) throws IOException {
        initFileObject();
        XSSFSheet sheet = initExcel.getWorkbook().getSheet(sheetName);
        int sheetNum = initExcel.getWorkbook().getSheetIndex(sheetName);
        int n = initExcel.getWorkbook().getSheet(sheetName).getLastRowNum();

        System.out.println("Rows removed: ");
        for (int i= initExcel.getWorkbook().getSheet(sheetName).getFirstRowNum(); i<= n; i++ ){
            System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
            sheet.removeRow(sheet.getRow(i));
        }

        writeIntoFile();
    }

    private static void writeIntoFile() {

        try {
            fileOut = new FileOutputStream(initExcel.getFilePath());
            initExcel.getWorkbook().write(fileOut);
            System.out.println("File Write Success");
        } catch (FileNotFoundException e) {
            System.out.println("File Write failed");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void initFileObject() throws IOException {
        initExcel = new ExcelPojo(Constants.FILEPATH, Constants.TOGGLE_SHEET_NAME, Constants.PARAMETER_SHEET_NAME);
    }

}
