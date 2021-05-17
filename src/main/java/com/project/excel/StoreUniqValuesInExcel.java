package com.project.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class StoreUniqValuesInExcel {
    private static ExcelPojo excelSetter;


    /**
     *
     * 1. Read row wise data from the excel and make it key value pair
     * 2. Able to identify a column header [Toggle/Toggles] and get all the column values of it
     * 3. Toggles values are specified in [:] separated values which essentially as [togglelass:set/unset]
     * 3. Maintain new sheet as "ToggleSettings" and just drop values with some logic which is explained below
     *
     * Drop Logic:
     * [toggle1:set] -> Add -> [toggle1:set]
     * [toggle2:set] -> Add -> [toggle2:set]
     * [toggle1:unset] -> Add -> [toggle1:unset] -> Remove -> [toggle1:set]
     * [toggle2:set] -> Already Existing
     * [toggle1:unset] -> Already Existing
     * [toggle1:set] -> Add -> [toggle1:set] -> Remove -> [toggle1:unset]
     *
     *
     * Do the above logic by checking or iterating the arraylist every time when there is a request to add new toggle
     *
     */


    /**
     * Algorithm
     * <p>
     * 1. Read the excel,sheet and table tag
     * 2. Get the column name toggle, Parameter etc which should be added as the global param
     * 3.
     */

    public static void main(String[] args) throws IOException {
        {
            XSSFWorkbook workbook = null;
            XSSFSheet sheet = null;


            String file = "testfile.xlsx";
            String filePath = "/Users/i331477/git/S4MicroServiceKatalon/Test Files/dms/ExcelValidations/" + file;
            String toggleSheet = "Toggles";
            String paramSheet = "Parameters";
            String dataTableName = "Attributes1";
            String columnHeader = "Type";

            /*FileInputStream fis = new FileInputStream(filePath);
            fis.available();
            workbook = new XSSFWorkbook(fis);
            System.out.println(workbook.getSheetAt(2));
            sheet = workbook.getSheet(toggleSheet);*/


            excelSetter = new ExcelPojo(filePath,toggleSheet,paramSheet);

            List<String> list = new ArrayList<String>();
            list.add("blore");
            list.add("Delhi");
            list.add("Channai");
            list.add("Hydrabad");


            //writeValuesIntoSheet(filePath, workbook, sheet, list);
            //deleteValueFromCellAndShiftCells(filePath, workbook, sheet, list);
            //saveFile(filePath, workbook);
            //getCellValuesUnderAHeader(filePath, workbook, sheet,"Header");
            //setToggles();
            List<String> toggleList = new ArrayList<String>();
            toggleList.add("XXX:unset");
            registerToggles(toggleList);
        }
    }

    private static void writeValuesIntoSheet(String filePath, XSSFWorkbook workbook, XSSFSheet sheet, List<String> list) throws IOException {

        //read sheet name and the table name

        int rowCount = 0;

        for (Object s : list) {
            Row row = sheet.createRow(++rowCount);
            int columnCount = 0;
            Cell cell = row.createCell(++columnCount);
            if (s instanceof String) {
                cell.setCellValue((String) s);
            } else if (s instanceof Integer) {
                cell.setCellValue((Integer) s);
            }
            System.out.println("Row Count"+ columnCount);
        }

        System.out.println("Row Count"+ rowCount);


        /*FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();*/
    }


    private static void deleteValueFromCellAndShiftCells(String filePath, XSSFWorkbook workbook, XSSFSheet sheet, List<String> list) throws IOException {

        XSSFCell cell = sheet.getRow(3).getCell(1);

        System.out.println(cell.getStringCellValue());

        sheet.getRow(2).removeCell(cell);


        /*FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();*/
    }

    private static void saveFile(String filePath, XSSFWorkbook workbook) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        //outputStream.close();
    }

    private static List<String> getCellValuesUnderAHeader(String filePath, XSSFWorkbook workbook, XSSFSheet sheet, String headerName){

        List<String> list = new ArrayList<String>();

        /*
         1. Identify the header by iterating the cells in each row
         2. Get the second value from the header
         3. Iterate till the last rows for that cell
         4. Store String values in the list
         */
            int rowStartNumb = 0;
            int toggleCellIdx = 0;
            int firstCell = 0;
            int lastCell = 0;
            //List<String> list = new ArrayList<String>();
            Iterator<Row> rows = sheet.iterator();
            while (rows.hasNext()){
                Row row = rows.next();
                Iterator<Cell> cells = row.iterator();
                while(cells.hasNext()){
                    Cell cell = cells.next();
                    if(cell.getStringCellValue().equalsIgnoreCase(headerName.trim())){
                        System.out.println(row.getRowNum());
                        System.out.println(cell.getColumnIndex());
                        toggleCellIdx = cell.getColumnIndex();
                        rowStartNumb = row.getRowNum();
                        firstCell = row.getFirstCellNum();
                        lastCell = row.getLastCellNum();
                        break;
                    //TODO:
                        /*
                        - Get the cell next to Header and get the last cell
                        - Iterate all the cell till last
                        - add cell values in the list
                         */




                    }


                }

               // System.out.println("values: "+row.getCell(toggleCellIdx).getStringCellValue());


            }

        /*Iterator<Row> rowss = sheet.iterator();
        while (rowss.hasNext()){
            Row row = rowss.next();
            System.out.println("values: "+row.getCell(toggleCellIdx).getStringCellValue());
        }*/

        for(int i= rowStartNumb+1; i<= sheet.getLastRowNum(); i++){
            if(sheet.getRow(i) == null){
                //System.out.println("values: NULL");
                continue;
            }
            System.out.println("values: "+ sheet.getRow(i).getCell(toggleCellIdx).getStringCellValue());
        }


        /*for(Row row: sheet){

            if(row.getCell(toggleCellIdx).getStringCellValue() != null){
                System.out.println("values: "+row.getCell(toggleCellIdx).getStringCellValue());
            }
        }*/


        return list;

    }


    private static void setToggles(/*Map<String,String> toggleValues*/){

        System.out.println(excelSetter.getFilePath());
        System.out.println(excelSetter.getWorkbook());
        System.out.println(excelSetter.getSheet("toggle"));
        System.out.println(excelSetter.getSheet("param"));

    }

    private static void registerToggles(List<String> toggles){
        writeValuesIntoSheet1("toggle", toggles);
    }

    private static void writeValuesIntoSheet1(String toggle, List<String> toggles) {
        if(toggle.equalsIgnoreCase("toggle")){
            XSSFSheet toggleSheet = excelSetter.getSheet("toggle");
            Iterator<Row> rows = excelSetter.getSheet("toggle").iterator();
            List<String> exsitingToggles = new ArrayList<String>();
            for(int i= toggleSheet.getFirstRowNum()+1 ; i<= toggleSheet.getLastRowNum(); i++){
                String vals = toggleSheet.getRow(i).getCell(0).getStringCellValue();
                //System.out.println("toggles: "+ vals);
                exsitingToggles.add(vals);
            }

            for (int i = 0; i< exsitingToggles.size(); i++){
                System.out.println(exsitingToggles.get(i));
            }


            List<String> consolidatedArrayList = new ArrayList<String>();
            //Collections.copy(consolidatedArrayList, exsitingToggles);

            boolean flag = false;

            if (exsitingToggles.size() == 0) {
                flag = true;
                //TODO: add toggle list values into sheet
            } else {
                for(int i=0; i< toggles.size(); i++) {

                    for (int j = 0; j < exsitingToggles.size(); j++) {

                        if (!(toggles.get(i).equalsIgnoreCase(exsitingToggles.get(j)))) {
                            if (toggles.get(i).split(":")[0].equalsIgnoreCase(exsitingToggles.get(j).split(":")[0])) {
                                System.out.println("removed toggle is: " + exsitingToggles.get(j));
                                exsitingToggles.remove(i);
                            } else {
                                exsitingToggles.add(toggles.get(i));
                            }

                        } else if (toggles.get(i).equalsIgnoreCase(exsitingToggles.get(j))) {
                            continue;
                        }
                    }
                }
            }



            if(flag){
                exsitingToggles = toggles;
            }

        }

    }


    private void writeMapValuesToExcel(String filePath, XSSFWorkbook workbook, XSSFSheet sheet, List<String> list){

    }

}
