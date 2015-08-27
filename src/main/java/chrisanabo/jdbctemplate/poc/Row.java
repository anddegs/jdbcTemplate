package chrisanabo.jdbctemplate.poc;

public class Row {

	public Row(String region, String gender, String hobby, int price, double units) {
		super();
		this.region = region;
		this.gender = gender;
		this.price = price;
		this.units = units;
		this.hobby = hobby;
		
	}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getUnits() {
		return units;
	}
	public void setUnits(double units) {
		this.units = units;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String region;
	public String gender;
	public int price;
	public double units;
	public String hobby;
	
}
