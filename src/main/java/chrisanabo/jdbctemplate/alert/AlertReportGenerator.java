package chrisanabo.jdbctemplate.alert;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import chrisanabo.jdbctemplate.util.ReportGenerator;

public class AlertReportGenerator {

	public void generateAlertBreakDownReport( List<Map<String,Object>>alerts ){
		    String row[] = new String[]{"REGION", "ALERT_TYPE","CURRENCY_PAIR"};
		    String column[] = new String[]{"BUSINESS_DT"};

		    URL url = this.getClass().getResource("/");
		    if (url == null) {
		         // error - missing folder
		    } else {
		        File dir = null;
		        try {
		            dir = new File(url.toURI());
		            String outputDirectory = dir.getAbsolutePath() + File.separator + "_alerts.xlsx";

		            System.out.println( outputDirectory );
		            ReportGenerator repGen = new ReportGenerator(  row, column, outputDirectory);
		                            repGen.generateReport(alerts);
		                            
		            boolean condition = new File(outputDirectory  ).exists();   
		            Assert.assertTrue(condition);
		        } catch (URISyntaxException e) {
		            e.printStackTrace();
		        }

		    }
	}
	
	public void generateAlertBreakDownReport( String startDate, String endDate ){
	    
	}
	
	
}
