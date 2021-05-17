package com.project.excelpoc;



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


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm
 * <p>
 * 1. Read the excel,sheet and table tag
 * 2. Get the column name toggle, Parameter etc which should be added as the global param
 * 3.
 */

public class Main {

    // Send List of toggles Strings to be stored

    List<String> inputToggleList = new ArrayList<String>();

    // Get the actual list of toggle Strings stored


    public static void main(String[] args) throws IOException {

        ExcelToggleParamStoreStrategy registry = new ExcelToggleParamStoreStrategy();

        // Send List of toggle Strings to be stored in excel
        List<String> inputToggleList = new ArrayList<String>();
        inputToggleList.add("shashi1:unset");
        inputToggleList.add("shashi2:unset");


        List<String> ipParams = new ArrayList<String>();
        ipParams.add("Param66");
        ipParams.add("Param67");
        ipParams.add("Param68");
        ipParams.add("Param69");

        List<String> toggleVals = registry.registerTogglesAndGetActualToEnable(inputToggleList);


        //ExcelToggleParamStoreStrategy registry1 = new ExcelToggleParamStoreStrategy();
        List<String> paramVals = registry.registerParametersAndGetActualToEnable(ipParams);


        System.out.println("Toggles: "+toggleVals.size());
        System.out.println("Toggles: "+toggleVals.toString());
        System.out.println("Params: "+paramVals.toString());

        //registry.clearToggles("toggle");
        //registry.clearSheets("Parameters");
    }



}
