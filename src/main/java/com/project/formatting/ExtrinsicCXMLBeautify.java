package com.project.formatting;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import java.io.StringWriter;

public class ExtrinsicCXMLBeautify
{

    /**
     *
     * characters  represented as below because these characters are special characters for xml:
     * < is represented as &lt;
     * > is represented as &gt;
     * “ is represented as &quot;
     * Therefore I have attached a separate cleaned up and formatted data for advanced pricing separately for contract and sourcing each.
     *
     * Thanks,
     */



    //static String rawCxml = "&lt;![CDATA[&lt;ValidityPeriods&gt;&lt;ValidityPeriod&gt;&lt;StartDate&gt;8/1/2019&lt;/StartDate&gt;&lt;EndDate&gt;8/31/2019&lt;/EndDate&gt;&lt;Scales&gt;&lt;Scale from = &quot;0&quot; to =&quot;34&quot;&gt;&lt;Term name =&quot;Price&quot; value = &quot;111.00&quot; currency = &quot;USD&quot;/&gt;&lt;Term name =&quot;Extended Price&quot; value = &quot;3774&quot; currency = &quot;USD&quot;/&gt;&lt;/Scale&gt;&lt;Scale from = &quot;0&quot; to =&quot;55&quot;&gt;&lt;Term name =&quot;Price&quot; value = &quot;111.00&quot; currency = &quot;USD&quot;/&gt;&lt;Term name =&quot;Extended Price&quot; value = &quot;6105&quot; currency = &quot;USD&quot;/&gt;&lt;/Scale&gt;&lt;Scale from = &quot;0&quot; to =&quot;60&quot;&gt;&lt;Term name =&quot;Price&quot; value = &quot;111.00&quot; currency = &quot;USD&quot;/&gt;&lt;Term name =&quot;Extended Price&quot; value = &quot;6660&quot; currency = &quot;USD&quot;/&gt;&lt;/Scale&gt;&lt;/Scales&gt;&lt;/ValidityPeriod&gt;&lt;ValidityPeriod&gt;&lt;StartDate&gt;9/1/2019&lt;/StartDate&gt;&lt;EndDate&gt;9/30/2019&lt;/EndDate&gt;&lt;Scales&gt;&lt;Scale from = &quot;0&quot; to =&quot;34&quot;&gt;&lt;Term name =&quot;Price&quot; value = &quot;111.00&quot; currency = &quot;USD&quot;/&gt;&lt;Term name =&quot;Extended Price&quot; value = &quot;3774&quot; currency = &quot;USD&quot;/&gt;&lt;/Scale&gt;&lt;Scale from = &quot;0&quot; to =&quot;55&quot;&gt;&lt;Term name =&quot;Price&quot; value = &quot;111.00&quot; currency = &quot;USD&quot;/&gt;&lt;Term name =&quot;Extended Price&quot; value = &quot;6105&quot; currency = &quot;USD&quot;/&gt;&lt;/Scale&gt;&lt;Scale from = &quot;0&quot; to =&quot;60&quot;&gt;&lt;Term name =&quot;Price&quot; value = &quot;111.00&quot; currency = &quot;USD&quot;/&gt;&lt;Term name =&quot;Extended Price&quot; value = &quot;6660&quot; currency = &quot;USD&quot;/&gt;&lt;/Scale&gt;&lt;/Scales&gt;&lt;/ValidityPeriod&gt;&lt;/ValidityPeriods&gt;]]&gt;";

    static String rawCxml = "&lt;![CDATA[&lt;ValidityPeriods&gt;&lt;ValidityPeriod&gt;&lt;StartDate&gt;8/1/2019&lt;/StartDate&gt;&lt;EndDate&gt;8/31/2019&lt;/EndDate&gt;&lt;PeriodQuantity periodprice=&quot;55.00&quot; currency = &quot;USD&quot;&gt;4&lt;/PeriodQuantity&gt;&lt;Scales&gt;&lt;Scale from = &quot;0&quot; to =&quot;10&quot;&gt;&lt;Term name =&quot;Price&quot; value = &quot;55.00&quot; currency = &quot;USD&quot;/&gt;&lt;Term name =&quot;Extended Price&quot; value = &quot;550.00&quot; currency = &quot;USD&quot;/&gt;&lt;/Scale&gt;&lt;Scale from = &quot;0&quot; to =&quot;20&quot;&gt;&lt;Term name =&quot;Price&quot; value = &quot;55.00&quot; currency = &quot;USD&quot;/&gt;&lt;Term name =&quot;Extended Price&quot; value = &quot;1100.00&quot; currency = &quot;USD&quot;/&gt;&lt;/Scale&gt;&lt;/Scales&gt;&lt;/ValidityPeriod&gt;&lt;ValidityPeriod&gt;&lt;StartDate&gt;9/1/2019&lt;/StartDate&gt;&lt;EndDate&gt;9/30/2019&lt;/EndDate&gt;&lt;PeriodQuantity periodprice=&quot;55.00&quot; currency = &quot;USD&quot;&gt;5&lt;/PeriodQuantity&gt;&lt;Scales&gt;&lt;Scale from = &quot;0&quot; to =&quot;10&quot;&gt;&lt;Term name =&quot;Price&quot; value = &quot;55.00&quot; currency = &quot;USD&quot;/&gt;&lt;Term name =&quot;Extended Price&quot; value = &quot;550.00&quot; currency = &quot;USD&quot;/&gt;&lt;/Scale&gt;&lt;Scale from = &quot;0&quot; to =&quot;20&quot;&gt;&lt;Term name =&quot;Price&quot; value = &quot;55.00&quot; currency = &quot;USD&quot;/&gt;&lt;Term name =&quot;Extended Price&quot; value = &quot;1100.00&quot; currency = &quot;USD&quot;/&gt;&lt;/Scale&gt;&lt;/Scales&gt;&lt;/ValidityPeriod&gt;&lt;/ValidityPeriods&gt;]]&gt;";

    public static void main (String[] args)
    {
        System.out.println("Convert raw cxml");
        String cleanCXML = getFormattedCXML(rawCxml);
        System.out.println(cleanCXML);
    }

    private static String getFormattedCXML(String inputXML)
    {
        String clensedXML;
        String result = null;

        String fullXml = inputXML.replaceAll("&lt;","<").replaceAll("&gt;",">")
            .replaceAll("&quot;","\"");

        clensedXML = fullXml.substring(9,fullXml.length()-3);

        try{
            Document doc = DocumentHelper.parseText(clensedXML);
            StringWriter sw = new StringWriter();
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter xw = new XMLWriter(sw, format);
            xw.write(doc);
            result = sw.toString();
        } catch (Exception e){
            e.getStackTrace();
        }

        return result;
    }

}
