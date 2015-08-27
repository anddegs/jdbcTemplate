package chrisanabo.jdbctemplate.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class AlertMsgParser {

	
	public  static List<Map<String,Object>> parseAlertMessage(StringBuilder alertMessage){
		
		StringTokenizer token = new StringTokenizer(alertMessage.toString().replace("{", "").replace("}", ""), "<");
		List<Map<String,Object>> alerts = new ArrayList<Map<String,Object>>();
		
		while (token.hasMoreElements()) {
			String record[] = token.nextToken().replace(">,","").replace(">","").split(",");
			Map<String,Object> map = new HashMap<String,Object>();
			for (int i = 0; i < record.length; i++) {
				String[] m = record[i].split("=");
				map.put(m[0], m[1]);
			} 
			alerts.add(map);
		}
		return alerts;
	}
}
