package com.project.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class ArrayListToMap
{
    String pcVals =
        "[\n"
            + "\t[Validity Period, Volume, TotalCost_CustomFormula, Price, Extended Price, Discount Amount, Shipping Cost, Surcharge Amount], \n"
            + "\t[\n"
            + "\t\t[Mar 2019, To 22, $130.00 USD, $200.00, $4,400.00 USD, $50.00, $10.00, $10.00], \n"
            + "\t\t[Mar 2019, To 44, $130.00 USD, $200.00, $8,800.00 USD, $50.00, $10.00, $10.00], \n"
            + "\t\t[Apr 2019, To 22, $130.00 USD, $200.00, $4,400.00 USD, $50.00, $10.00, $10.00], \n"
            + "\t\t[Apr 2019, To 44, $130.00 USD, $200.00, $8,800.00 USD, $50.00, $10.00, $10.00]\n"
            + "\t\t]\n" + "\t]";


    public static void main (String[] args)
    {

        /*System.out.println("PC Vals: \n" + pcVals);

        System.out.println("XXX: \n "+ Arrays.asList(pcVals));

        ArrayList<String> pcFull =new ArrayList<String>(Arrays.asList(pcVals));*/

        //String headers = pcFull.get(0);
        //String pcDetails = pcFull.get(1);

        /*if(pcVals instanceof ArrayList){
            System.out.println("AAA: "+pcVals.size());
        }else{
            System.out.println("BBB: ");
        }*/


        //System.out.println("BBB: "+pcDetails);
    }
}
