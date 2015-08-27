package chrisanabo.excel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import chrisanabo.excel.util.ReportGenerator;

public class TestReportGenerator {

@Test
public void test() {

    List<Map<String,Object>> summary = createDummyData();
    String row[] = new String[]{"date", "book","symbol"};
    String column[] = new String[]{"trader"};

    URL url = this.getClass().getResource("/");
    if (url == null) {
         // error - missing folder
    } else {
        File dir = null;
        try {
            dir = new File(url.toURI());
            String outputDirectory = dir.getAbsolutePath() + "\\";

            ReportGenerator repGen = new ReportGenerator(  row, column, outputDirectory);
                            repGen.generateReport(summary);
            boolean condition = new File(outputDirectory + "20150101_report.xlsx" ).exists();   
            Assert.assertTrue(condition);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }




}


public List<Map<String,Object>> createDummyData(){

    List<Map<String,Object>> summary = new ArrayList<Map<String,Object>>();

    Map<String,Object> record = new LinkedHashMap<String,Object>();
                       record.put("trader","trader A");
                       record.put("book", "Book A");
                       record.put("symbol","USD/SGD");
                       record.put("date", "2015-02-10");
                     //  record.put("dummy", "1");

                       summary.add(record);


                       record = new LinkedHashMap<String,Object>();
                       record.put("trader","trader A");
                       record.put("book", "Book B");
                       record.put("symbol","USD/SGD");
                       record.put("date", "2015-02-10");
                     //  record.put("dummy", "1");

                       summary.add(record);

                       record = new LinkedHashMap<String,Object>();
                       record.put("trader","trader A");
                       record.put("book", "Book C");
                       record.put("symbol","USD/SGD");
                       record.put("date", "2015-02-10");
                    //   record.put("dummy", "1");

                       summary.add(record);

                       record = new LinkedHashMap<String,Object>();
                       record.put("trader","trader B");
                       record.put("book", "Book A");
                       record.put("symbol","USD/SGD");
                       record.put("date", "2015-02-10");
                    //   record.put("dummy", "1");

                       summary.add(record);

                       record = new LinkedHashMap<String,Object>();
                       record.put("trader","trader B");
                       record.put("book", "Book B");
                       record.put("symbol","USD/SGD");
                       record.put("date", "2015-02-10");
                     //  record.put("dummy", "1");

                       summary.add(record);


                       return summary;

}
}