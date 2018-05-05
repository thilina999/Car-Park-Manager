package myCarPark;

public abstract class Vehicle {
	private String id;
	private String brand;
	private DateTime DateTime;
	private DateTime ExitDateTime;
	
	abstract String getType();
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id; 
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public DateTime getDateTime() {
		return DateTime;
	}

	public void setDateTime(DateTime DateTime) {
		this.DateTime = DateTime; 
	}

	public DateTime getExitDateTime() {
		return ExitDateTime;
	}

	public void setExitDateTime(DateTime ExitDateTime) {
		this.ExitDateTime = ExitDateTime; 
	}
	
	
}
