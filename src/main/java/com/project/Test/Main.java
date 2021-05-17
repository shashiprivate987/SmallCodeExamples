package com.project.Test;

import java.io.IOException;

public class Main {



    public static void main(String[] args) throws IOException, NoSuchFieldException {
        /*String file = "TestData.xlsx";
        String fileFullPath = "/Users/i331477/git/S4MicroServiceKatalon/Test Files/dms/ExcelValidations/" + file;
        String sheet = "Shashi_pricingConditions";
        String dataTableName = "DataSet3";

        FetchDataFromDataTable fetchData = new FetchDataFromDataTable();

        // Get cells values from all the row in a data table
        List<Map<String,String>> rowList = fetchData.getAllDataFromAllRows(fileFullPath,sheet,dataTableName);

        for (Map<String, String> map: rowList){

            for(Map.Entry<String,String> entry: map.entrySet()){
                System.out.println("Header: "+ entry.getKey()+" || "+"Value: "+ entry.getValue());
            }
        }

        // Get all the cell values from the first row in a data table
        Map<String,String> cellVals = fetchData.getCellValuesOfRow(null,null,sheet,dataTableName, 4);
        System.out.println("CITY: "+ cellVals.get("City"));
        for(Map.Entry<String,String> entry: cellVals.entrySet()) {
            System.out.println("Header: " + entry.getKey() + " || " + "Value: " + entry.getValue());
        }

        // Get any specific column value by mentioning column header of the first row in a data table
        fetchData.getCellValueForKey("City");
        fetchData.getCellValueForKey("toggles");
        fetchData.getCellValueForKey("parameters");*/





        int x = 10;
        int y = 20;
        int z = 30;

        int m = getListValues(x);
        int n = getListValues(y);
        int o = getListValues(z);

        System.out.println(m);
        System.out.println(n);
        System.out.println(o);
    }

    private static int getListValues(int x) {

        int sum = addtwoNum(10,x);

        return sum;
    }

    private static int addtwoNum(int a, int b) {


        return a+b;
    }

}
