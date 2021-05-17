package com.project.Test;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.io.IOException;
import java.util.*;

public class FetchDataFromDataTable {

    private static int rowStartNum;
    private static int rowEndNum;
    ExcelInit util = null;

    public FetchDataFromDataTable() {
    }

    public Map<String,String> getCellValuesOfRow(String filePath, String fileName, String sheet, String dataTableName,int rowNum) throws IOException, NoSuchFieldException {
        String file = "TestData.xlsx";
        String fileFullPath = "/Users/i331477/git/S4MicroServiceKatalon/Test Files/dms/ExcelValidations/" + file;
        util = new ExcelInit(fileFullPath, sheet);
        List<String> cellValues = null;
        int dataTableCount = 0;
        boolean flag = false;
        int rowCnt = 0;
        int tagCnt = 0;
        int rowStart = 0;
        int rowEnd = 0;
        List<Row> rowList = new ArrayList<Row>();
        Map<String,String> cellValue = new HashMap<String, String>();
        Iterator<Row> rows = util.getSheetObj().iterator();

        while (rows.hasNext()) {
            Row row = rows.next();
            String tableTag = row.iterator().next().toString();

            if (tableTag.equalsIgnoreCase(dataTableName)) {
                tagCnt++;

                if(tagCnt == 1){
                    rowStart = row.getRowNum() + 2;
                    setRowStartNum(rowStart);
                }

                if(tagCnt == 2){
                    rowEnd = row.getRowNum();
                    setRowEndNum(rowEnd);
                }
            }
        }

        if(tagCnt == 2){
            flag = true;
        }else{
           // KeywordUtil.logInfo("Number of table tags seems to be : "+tagCnt+" in the sheet, hence it is Invalid Table Tags, Please check the tags again...");
            throw new NoSuchFieldException("Invalid Table Tags, Please check the tags again...");
        }

        if(flag){
            for(int i= rowStart-1; i< rowEnd; i++){
                rowList.add(util.getSheetObj().getRow(i));
            }
        }

        int startCellNum = util.getSheetObj().getRow(rowStart-1).getFirstCellNum();
        int endCellNum = util.getSheetObj().getRow(rowStart-1).getLastCellNum();

        /*System.out.println("Cell Headers: ");
        for(int i=startCellNum; i<endCellNum; i++){
            String cellVal = util.getSheetObj().getRow(rowStart-1).getCell(i).getStringCellValue();
            //System.out.println(cellVal);
        }


        System.out.println("Cell Values from first row: ");
        for(int i=startCellNum; i<endCellNum; i++){
            String cellVal = util.getSheetObj().getRow(rowStart).getCell(i).getStringCellValue();
            //System.out.println(cellVal);
        }*/

        List<String> listOfVals = new ArrayList<String>();
        Map<String,String> map = new HashMap<String, String>();

        for(int i=startCellNum; i<endCellNum; i++){
            String cellHeader = "";
            String cellVal = "";
            int headerRow = rowStart-1;
            if(util.getSheetObj().getRow(headerRow) != null && util.getSheetObj().getRow(headerRow).getCell(i) != null){
                cellHeader = util.getSheetObj().getRow(headerRow).getCell(i).getStringCellValue();
            }

            if(util.getSheetObj().getRow(headerRow + rowNum) != null && util.getSheetObj().getRow(headerRow + rowNum).getCell(i) != null) {
                cellVal = util.getSheetObj().getRow(headerRow + rowNum).getCell(i).getStringCellValue();
            }

            map.put(cellHeader,cellVal);
        }

        /*for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println("Header: "+ entry.getKey()+" || "+"Value: "+ entry.getValue());
        }*/

        /*int firstCell = rowList.get(0).getFirstCellNum();
        rowList.get(0).getFirstCellNum();*/

        return map;
    }



    public String getCellValueForKey(String key) throws NoSuchFieldException {

        List<String> cellValues = null;
        int dataTableCount = 0;
        boolean flag = false;
        int rowCnt = 0;
        int tagCnt = 0;
        int rowStart = 0;
        int rowEnd = 0;
        String dataTableName = "DataSet3";
        String mappingValue = null;
        Iterator<Row> rows = util.getSheetObj().iterator();

        while (rows.hasNext()) {
            Row row = rows.next();
            String tableTag = row.iterator().next().toString();

            if (tableTag.equalsIgnoreCase(dataTableName)) {
                tagCnt++;

                if(tagCnt == 1){
                    rowStart = row.getRowNum() + 2;
                    setRowStartNum(rowStart);
                }

                if(tagCnt == 2){
                    rowEnd = row.getRowNum();
                    setRowEndNum(rowEnd);
                }
            }
        }

        if(tagCnt == 2){
            flag = true;
        }else{
            // KeywordUtil.logInfo("Number of table tags seems to be : "+tagCnt+" in the sheet, hence it is Invalid Table Tags, Please check the tags again...");
            throw new NoSuchFieldException("Invalid Table Tags, Please check the tags again...");
        }

        int startCellNum = util.getSheetObj().getRow(rowStart-1).getFirstCellNum();
        int endCellNum = util.getSheetObj().getRow(rowStart-1).getLastCellNum();
        List<String> listOfVals = new ArrayList<String>();
        Map<String,String> map = new HashMap<String, String>();
        for(int i=startCellNum; i<endCellNum; i++){
            String cellheader = util.getSheetObj().getRow(rowStart-1).getCell(i).getStringCellValue();
            String cellVal = util.getSheetObj().getRow(rowStart).getCell(i).getStringCellValue();
            map.put(cellheader,cellVal);
        }

        for(Map.Entry<String,String> entry: map.entrySet()){
            //System.out.println("Header: "+ entry.getKey()+" || "+"Value: "+ entry.getValue());

            if(entry.getKey().equalsIgnoreCase(key)){
                System.out.println("Value for given key: "+key+ " is : "+entry.getValue());
                mappingValue = entry.getValue();
                return mappingValue;
            }
        }


        return null;
    }


    private void setRowStartNum(int rowStart){
        this.rowStartNum = rowStart;
    }

    private void setRowEndNum(int rowEnd){
        this.rowEndNum = rowEnd;
    }

    public List<Map<String,String>> getAllDataFromAllRows(String fileFullPath, String sheet, String dataTableName) throws NoSuchFieldException, IOException {
        List<String> cellValues = null;
        int dataTableCount = 0;
        boolean flag = false;
        int rowCnt = 0;
        int tagCnt = 0;
        int rowStart = 0;
        int rowEnd = 0;
        String mappingValue = null;
        util = new ExcelInit(fileFullPath, sheet);
        Iterator<Row> rows = util.getSheetObj().iterator();

        while (rows.hasNext()) {
            Row row = rows.next();
            String tableTag = row.iterator().next().toString();

            if (tableTag.equalsIgnoreCase(dataTableName)) {
                tagCnt++;

                if(tagCnt == 1){
                    rowStart = row.getRowNum() + 2;
                    setRowStartNum(rowStart);
                }

                if(tagCnt == 2){
                    rowEnd = row.getRowNum();
                    setRowEndNum(rowEnd);
                }
            }
        }

        if(tagCnt == 2){
            flag = true;
        }else{
            // KeywordUtil.logInfo("Number of table tags seems to be : "+tagCnt+" in the sheet, hence it is Invalid Table Tags, Please check the tags again...");
            throw new NoSuchFieldException("Invalid Table Tags, Please check the tags again...");
        }


        List<XSSFRow> rowList1 = new ArrayList<XSSFRow>();

        if(flag){
            for(int i= rowStart-1; i< rowEnd; i++){
                rowList1.add(util.getSheetObj().getRow(i));
            }
        }



        List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();
        for(int i=rowStart; i< rowEnd; i++){

            int startCellNum = util.getSheetObj().getRow(rowStart-1).getFirstCellNum();
            int endCellNum = util.getSheetObj().getRow(rowStart-1).getLastCellNum();
            List<String> listOfVals = new ArrayList<String>();
            Map<String,String> mapOfCellValues = new HashMap<String, String>();

            for(int j=startCellNum; j<endCellNum; j++){
                String cellHeader = "";
                String cellVal = "";
                if(null != util.getSheetObj().getRow(rowStart-1).getCell(j)){
                    cellHeader = util.getSheetObj().getRow(rowStart-1).getCell(j).getStringCellValue();
                }

                if(null != util.getSheetObj().getRow(i).getCell(j)){
                    cellVal = util.getSheetObj().getRow(i).getCell(j).getStringCellValue();
                }

                mapOfCellValues.put(cellHeader,cellVal);
            }

            rowList.add(mapOfCellValues);
        }

        /*// Get List of Rows and foreach row

        Map<String,String> cells = new HashMap<String, String>();
        cells.put("head1","x");


        List<String> rowList1 = new ArrayList<String>();
        rowList1.add("a");
        rowList1.add("b");


        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        list.add(cells);*/

    return rowList;
    }



}
