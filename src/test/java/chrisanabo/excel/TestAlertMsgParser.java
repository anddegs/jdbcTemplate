package chrisanabo.excel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import chrisanabo.jdbctemplate.util.AlertMsgParser;

public class TestAlertMsgParser {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		StringBuilder alertMessage = new StringBuilder(
				"{<ALERT_ID=930993,BUSINESS_DT=08-MAY-15,ALERT_TYPE=Price Deviation,ALERT_STATUS=Open,CURRENCY_PAIR=MXN/USD,REGION=LATAM,AGING=40,LAST_UPDATED_TS_EST=15-JUL-15 05.58.38.000000000 AM,LAST_UPDATED_USER=SAGEDBO,LAST_COMMENT=null,REVIEWER=null>"
				+ ",<ALERT_ID=932575,BUSINESS_DT=27-MAY-15,ALERT_TYPE=Price Deviation,ALERT_STATUS=Open,CURRENCY_PAIR=SGD/USD,REGION=LATAM,AGING=40,LAST_UPDATED_TS_EST=15-JUL-15 05.59.07.000000000 AM,LAST_UPDATED_USER=SAGEDBO,LAST_COMMENT=null,REVIEWER=null>"
				+ ",<ALERT_ID=932963,BUSINESS_DT=29-MAY-15,ALERT_TYPE=Price Deviation,ALERT_STATUS=Open,CURRENCY_PAIR=BRL/USD,REGION=LATAM,AGING=40,LAST_UPDATED_TS_EST=15-JUL-15 05.59.11.000000000 AM,LAST_UPDATED_USER=SAGEDBO,LAST_COMMENT=null,REVIEWER=null>}");
		
			List<Map<String,Object>> alerts =  AlertMsgParser.parseAlertMessage(alertMessage);
			Assert.assertEquals(3, alerts.size() );
	        
			   
			 Map<String,Object> alert1 = alerts.get(0);
			 
			 Assert.assertEquals( "930993", alert1.get("ALERT_ID"));
			 Assert.assertEquals( "MXN/USD", alert1.get("CURRENCY_PAIR"));
			 Assert.assertEquals( "null", alert1.get("REVIEWER"));
			 Assert.assertNotEquals( "MXN/USxxD", alert1.get("CURRENCY_PAIR"));
			 	 
			 
			 Map<String,Object> alert2 = alerts.get(2);
			 Assert.assertEquals( "932963", alert2.get("ALERT_ID"));
			 Assert.assertEquals( "BRL/USD", alert2.get("CURRENCY_PAIR"));
			 Assert.assertEquals( "null", alert2.get("REVIEWER"));
			 Assert.assertNotEquals( "MXN/USxxD", alert2.get("CURRENCY_PAIR"));
			 
			 
	 
	}

}
