package com.project.excelpoc;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

class ExcelToggleParamStoreStrategy {

    private ExcelPojo initExcel = null;
    List<String> togglesToBeSet = new ArrayList<String>();
    List<String> paramsToBeSet = new ArrayList<String>();

    public ExcelToggleParamStoreStrategy() throws IOException {

        //initExcel = new ExcelPojo(Constants.FILEPATH, Constants.TOGGLE_SHEET_NAME, Constants.PARAMETER_SHEET_NAME);
    }


    public List<String> registerTogglesAndGetActualToEnable(List<String> toggles) throws IOException {
        initExcel = new ExcelPojo(Constants.FILEPATH, Constants.TOGGLE_SHEET_NAME, Constants.PARAMETER_SHEET_NAME);
        List<String> ipToggles = removeDuplicatesFromInputValues(toggles);
        List<String> existingToggles = getTotalExistingTogglesComparingNewToggles("toggle", ipToggles);
        writeTogglesIntoExcel(existingToggles, getTogglesTobeSet());
        return getTogglesTobeSet();
    }

    private List<String> removeDuplicatesFromInputValues(List<String> ipList) {
        Set<String> set = new LinkedHashSet<String>();
        set.addAll(ipList);
        ipList.clear();
        ipList.addAll(set);
        return ipList;
    }

    private void writeTogglesIntoExcel(List<String> existingToggles, List<String> togglesToBeSet) {

        List<String> concateAllToggles = new ArrayList<String>();

        int firstRow = initExcel.getSheet("toggle").getFirstRowNum();
        int lastRow = initExcel.getSheet("toggle").getLastRowNum();

        for (int i = firstRow + 1; i <= lastRow; i++) {
            initExcel.getSheet("toggle").removeRow(initExcel.getSheet("toggle").getRow(i));
        }

        if (existingToggles.equals(togglesToBeSet)) {
            concateAllToggles = togglesToBeSet;
        } else {
            concateAllToggles.addAll(existingToggles);
            concateAllToggles.addAll(togglesToBeSet);
        }


        for (int i = 0; i < concateAllToggles.size(); i++) {
            Row row = initExcel.getSheet("toggle").createRow(i + 1);
            row.createCell(0).setCellValue(concateAllToggles.get(i).trim());
        }

        writeIntoFile();

    }

    private void writeIntoFile() {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(initExcel.getFilePath());
            initExcel.getWorkbook().write(fileOut);
        } catch (FileNotFoundException e) {
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

    private List<String> getTotalExistingTogglesComparingNewToggles(String toggle, List<String> newToggles) {

        List<String> existingToggles = new ArrayList<String>();

        if (toggle.equalsIgnoreCase("toggle")) {
            XSSFSheet toggleSheet = initExcel.getSheet("toggle");
            Iterator<Row> rows = initExcel.getSheet("toggle").iterator();

            if(null != (toggleSheet.getRow(toggleSheet.getFirstRowNum() + 1).getCell(0).getStringCellValue())){
                for (int i = toggleSheet.getFirstRowNum() + 1; i <= toggleSheet.getLastRowNum(); i++) {
                    String vals = toggleSheet.getRow(i).getCell(0).getStringCellValue();
                    //System.out.println("toggles: "+ vals);
                    existingToggles.add(vals);
                }
            }



            //TODO:
            /*
                Old - existingToggles
                New - newToggles
            1. Check whether existingToggles array has no value, then set newToggles to existingToggles and return
            2. Iterate New across old and check below conditions
              a. If toggles match then continue and dont return it
              b. If toggles dont match then check first parts are matching
                 - if yes then check the second part of new (set or unset) then remove that item from old and add item from new into old
             */


            if (existingToggles.size() == 0) {
                togglesToBeSet = newToggles;
                return togglesToBeSet;
            }

            for (int i = 0; i < newToggles.size(); i++) {
                boolean isPresent = true;
                if (existingToggles.contains(newToggles.get(i))) {
                    continue;
                } else {
                    for (int j = 0; j < existingToggles.size(); j++) {
                        if (!(newToggles.get(i).equalsIgnoreCase(existingToggles.get(j)))) {
                            if (newToggles.get(i).split(":")[0].equalsIgnoreCase(existingToggles.get(j).split(":")[0])) {
                                isPresent = true;
                                if (newToggles.get(i).split(":")[1].equalsIgnoreCase("unset") ||
                                        newToggles.get(i).split(":")[1].equalsIgnoreCase("set")) {
                                    isPresent = true;
                                    togglesToBeSet.add(newToggles.get(i));
                                    existingToggles.remove(j);

                                    if (existingToggles.size() == 0) {
                                        togglesToBeSet = newToggles;
                                        return togglesToBeSet;
                                    }

                                    break;
                                } else {

                                    throw new IllegalArgumentException(" toggle format or name is wrong : " + newToggles.get(i));
                                }

                            } else {
                                isPresent = false;
                            }


                        }
                    }
                    if (!isPresent) {
                        togglesToBeSet.add(newToggles.get(i));
                    }

                }
            }


        }

        return existingToggles;

    }

    public List<String> getTogglesTobeSet() {
        return togglesToBeSet;
    }

    public List<String> getParamsTobeSet() {
        return paramsToBeSet;
    }

    //TODO: For parameters storing do as below
    /*
    1. Get all the input parameters
    2. Get all the existing parameters
    3. Iterate input params through existing params
    4.

     */

    public synchronized List<String> registerParametersAndGetActualToEnable(List<String> params) throws IOException {
        List<String>  actualParams = null;
        initExcel = new ExcelPojo(Constants.FILEPATH, Constants.TOGGLE_SHEET_NAME, Constants.PARAMETER_SHEET_NAME);
        List<String> ipParams = removeDuplicatesFromInputValues(params);

            List<String> existingParams = getExisingParams();
            actualParams = getActualParamsToBeAddedComparingWithExisting(existingParams,ipParams);
            writeParamsIntoExcel(existingParams,actualParams);


        return actualParams;
    }

    private void writeParamsIntoExcel(List<String> existingParams, List<String> actualParams) {
        int firstRow = initExcel.getSheet("params").getLastRowNum();
        int j =0;
        for (int i = firstRow + 1; i <= firstRow + actualParams.size(); i++) {
            Row row = initExcel.getSheet("params").createRow(i);
            row.createCell(0).setCellValue(actualParams.get(j).trim());
            j++;
        }

        writeIntoFile();
    }

    private List<String> getActualParamsToBeAddedComparingWithExisting(List<String> existingParams, List<String> ipParams) {


        if (existingParams.size() == 0 || existingParams == null) {
            paramsToBeSet = ipParams;
            return getParamsTobeSet();
        }

        for (Iterator<String> itr = ipParams.iterator(); itr.hasNext(); ) {
            String param = itr.next();
            if (!(existingParams.contains(param))) {
                paramsToBeSet.add(param);
            }

        }

        return getParamsTobeSet();
    }

    private List<String> getExisingParams() {
        List<String> existingParams = new ArrayList<String>();
        XSSFSheet paramSheet = initExcel.getSheet("parameters");
        Iterator<Row> rows = initExcel.getSheet("parameters").iterator();

        if (paramSheet.getLastRowNum() <= 0) {
            return existingParams;
        }

        for (int i = paramSheet.getFirstRowNum() + 1; i <= paramSheet.getLastRowNum(); i++) {
            String vals = paramSheet.getRow(i).getCell(0).getStringCellValue();
            existingParams.add(vals);
        }

        //System.out.println("Existing params: " + existingParams.toString());
        return existingParams;
    }


    public void clearToggles(String toggles) throws IOException {

        XSSFSheet sheet = initExcel.getWorkbook().getSheet("Toggles");
        clearContentsFromSheet(sheet);
        System.out.println("All Toggles cleared");
    }

    private void clearContentsFromSheet(XSSFSheet sheet) throws IOException {
        initExcel = new ExcelPojo(Constants.FILEPATH, Constants.TOGGLE_SHEET_NAME, Constants.PARAMETER_SHEET_NAME);

        Sheet sheet1 = initExcel.getSheet(sheet.getSheetName().trim());

        Iterator<Row> row = sheet1.iterator();
        while (row.hasNext()) {
            row.next();
            row.remove();
        }

        /*for (Row row : sheet1) {
            sheet1.removeRow(row);
        }*/
        writeIntoFile();
    }


    public void clearSheets(String sheetName) throws IOException {
        initExcel = new ExcelPojo(Constants.FILEPATH, Constants.TOGGLE_SHEET_NAME, Constants.PARAMETER_SHEET_NAME);
        XSSFSheet sheet = initExcel.getWorkbook().getSheet("Parameters");
        initExcel.getWorkbook().removeSheetAt(initExcel.getWorkbook().getSheetIndex(initExcel.getSheet(sheetName)));
        System.out.println(sheetName+ " sheet is removed..");
        writeIntoFile();
    }


}
