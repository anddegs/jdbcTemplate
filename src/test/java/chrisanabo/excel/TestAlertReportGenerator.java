package chrisanabo.excel;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import chrisanabo.jdbctemplate.alert.AlertReportGenerator;
import chrisanabo.jdbctemplate.util.AlertMsgParser;

public class TestAlertReportGenerator {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAlertReportGenerator() {
		List<Map<String,Object>> alerts =  AlertMsgParser.parseAlertMessage(dummyAlertMessage());
		AlertReportGenerator alertReportGenerator = new AlertReportGenerator();
		alertReportGenerator.generateAlertBreakDownReport(alerts);
		
	}

   private  static StringBuilder dummyAlertMessage(){
	
	 StringBuilder alertMessage = new StringBuilder(
			"{<ALERT_ID=930993,BUSINESS_DT=08-MAY-15,ALERT_TYPE=Price Deviation,ALERT_STATUS=Open,CURRENCY_PAIR=MXN/USD,REGION=LATAM,AGING=40,LAST_UPDATED_TS_EST=15-JUL-15 05.58.38.000000000 AM,LAST_UPDATED_USER=SAGEDBO,LAST_COMMENT=null,REVIEWER=null>"
			+ ",<ALERT_ID=932575,BUSINESS_DT=27-MAY-15,ALERT_TYPE=Price Deviation,ALERT_STATUS=Open,CURRENCY_PAIR=SGD/USD,REGION=LATAM,AGING=40,LAST_UPDATED_TS_EST=15-JUL-15 05.59.07.000000000 AM,LAST_UPDATED_USER=SAGEDBO,LAST_COMMENT=null,REVIEWER=null>"
			+ ",<ALERT_ID=932963,BUSINESS_DT=29-MAY-15,ALERT_TYPE=Price Deviation,ALERT_STATUS=Open,CURRENCY_PAIR=BRL/USD,REGION=LATAM,AGING=40,LAST_UPDATED_TS_EST=15-JUL-15 05.59.11.000000000 AM,LAST_UPDATED_USER=SAGEDBO,LAST_COMMENT=null,REVIEWER=null>"
			+ ",<ALERT_ID=932964,BUSINESS_DT=29-MAY-15,ALERT_TYPE=WASH,ALERT_STATUS=Open,CURRENCY_PAIR=BRL/USD,REGION=LATAM,AGING=40,LAST_UPDATED_TS_EST=15-JUL-15 05.59.11.000000000 AM,LAST_UPDATED_USER=SAGEDBO,LAST_COMMENT=null,REVIEWER=null>"
			+ ",<ALERT_ID=932965,BUSINESS_DT=29-MAY-15,ALERT_TYPE=SPOOF,ALERT_STATUS=Open,CURRENCY_PAIR=BRL/USD,REGION=LATAM,AGING=40,LAST_UPDATED_TS_EST=15-JUL-15 05.59.11.000000000 AM,LAST_UPDATED_USER=SAGEDBO,LAST_COMMENT=null,REVIEWER=null>"
			+ "}");
	
	 return alertMessage;
	
   }
}
