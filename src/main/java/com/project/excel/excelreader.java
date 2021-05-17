package com.project.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class excelreader {

    public static void main(String[] args) {

        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;


        try {
            String file = "ContractLotAPCContent.xlsx";
            String filePath = "/Users/i331477/git/S4MicroServiceKatalon/Test Files/dms/ExcelValidations/" + file;
            String sheetName = "Item Attributes";
            String dataTableName = "Attributes1";
            String columnHeader = "Type";

            FileInputStream fis = new FileInputStream(filePath);
            fis.available();
            workbook = new XSSFWorkbook(fis);
            System.out.println(workbook.getSheetAt(2));
            sheet = workbook.getSheet(sheetName);

            // readAllSheetNames(workbook);
            readRowwiseDataFromSheet(sheet, dataTableName);

            // get List of rows from the datatable
            List<Row> rowList = getRowsInsideTableTag(sheet, dataTableName);


            // Get List of Columns for a particular column Header
            List<String> columnVal = getAllValueForColumn(rowList, columnHeader);


            System.out.println("Rows: " + rowList.size());
            for (int row = 1; row < rowList.size(); row++) {

                //System.out.println((Row) rowList.get(row));
            }
            //System.out.println("Row Object: "+rowList);

            /**
             * TODO
             * 1. get excel and read the data sheet
             * 2. get the cell tags and read the excel values in it
             */


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<String> getAllValueForColumn(List<Row> rowList, String columnHeader) {

        int headerColNum = 0;
        List<String> columns = new ArrayList<String>();
        List<String> headerCol = new ArrayList<String>();


        Row headerRow = rowList.get(0);

        // Header Cell Values
        Iterator<Cell> headItr = headerRow.iterator();

        while (headItr.hasNext()) {
            headerCol.add(headItr.next().toString());
        }


        // based on the column header param, iterate all the columns under it

        for (int i = headerRow.getFirstCellNum(); i < headerRow.getLastCellNum(); i++) {

            if (headerRow.getCell(i).toString().trim().equalsIgnoreCase(columnHeader.trim())) {
                //headerColNum = i ;
                headerColNum = headerRow.getCell(i).getColumnIndex();

                break;

            }

        }


        // Iterate the Row List and get columns under column header

        System.out.println("DATA FETCHED: ");
        for (int i = 1; i < rowList.size(); i++) {

            Row myRow = rowList.get(i);


            System.out.print(" " + myRow.getCell(headerColNum).toString() + " ");


               /* int firstCellNum = myRow.getFirstCellNum();
                int lastCellNum = myRow.getLastCellNum();
                for(int j = firstCellNum; j<= lastCellNum; i++){

                    if(j == headerColNum){
                        columns.add(myRow.getCell(j).toString());
                    }

                }*/


        }


        return columns;
    }

    private static void readAllSheetNames(XSSFWorkbook workbook) {

        System.out.println("Sheets: " + workbook.getSheetAt(2).getSheetName());

        Iterator<XSSFSheet> itr = workbook.iterator();

        while (itr.hasNext()) {
            System.out.println("Sheets: " + itr.next().getSheetName());
        }


    }

    private static void readRowwiseDataFromSheet(XSSFSheet sheet, String dataTableName) {

        Iterator<Row> rows = sheet.iterator();
        int dataTableCount = 0;
        boolean flag = false;

        while (rows.hasNext()) {

            Row row = rows.next();
            String tableTag = row.iterator().next().toString();
            if (tableTag.equalsIgnoreCase(dataTableName)) {
                flag = true;
            }

            if (flag) {
                Iterator<Cell> cells = row.iterator();
                System.out.println("");
                while (cells.hasNext()) {

                    String cell = cells.next().toString();
                    if (cell.equalsIgnoreCase(dataTableName)) {
                        dataTableCount += 1;

                        if (rows.hasNext()) {
                            rows.next();
                        }
                        break;
                    }
                    System.out.print(" | " + cell + " | ");
                }
                System.out.println("");

                if (dataTableCount == 2) {
                    break;
                }
            }

        }


    }


    private static List<Row> getRowsInsideTableTag(XSSFSheet sheet, String dataTableName) {

        Iterator<Row> rows = sheet.iterator();
        int dataTableCount = 0;
        boolean flag = false;
        int rowCnt = 0;
        List<Row> rowList = new ArrayList<Row>();


        while (rows.hasNext()) {

            Row row = rows.next();
            String tableTag = row.iterator().next().toString();
            if (tableTag.equalsIgnoreCase(dataTableName) && !flag) {
                flag = true;
            } /*else {
                System.out.println("Invalid Data Table Name.");
                break;
            }*/

            if (tableTag.equalsIgnoreCase(dataTableName)) {
                rowCnt += 1;
                if (rowCnt == 2) {
                    break;
                }
            }

            if (flag && row.getRowNum() != 2) {

                if (!(tableTag.equalsIgnoreCase(dataTableName))) {
                    rowList.add(row);
                }
            }

        }

        return rowList;

    }

}
