package chrisanabo.jdbctemplate.poc;

public class AlertTrendinBreakDown {

	private String alertId;

	private String businessDate;

	private String month;

	private String alertType;

	private String alertStatus;
	private String currencyPair;
	private String region;
	private String lastUpdatedTsEst;
	private String lastUpdatedUser;
	
	private String lastComment;
	private String reviewer;
	
	
	public AlertTrendinBreakDown(String alertId, String businessDate,
			String month, String alertType, String alertStatus,
			String currencyPair, String region, String lastUpdatedTsEst,
			String lastUpdatedUser, String lastComment, String reviewer) {
		super();
		
		this.alertId = alertId;
		this.businessDate = businessDate;
		this.month = month;
		this.alertType = alertType;
		this.alertStatus = alertStatus;
		this.currencyPair = currencyPair;
		this.region = region;
		this.lastUpdatedTsEst = lastUpdatedTsEst;
		this.lastUpdatedUser = lastUpdatedUser;
		this.lastComment = lastComment;
		this.reviewer = reviewer;
	}

	
}
