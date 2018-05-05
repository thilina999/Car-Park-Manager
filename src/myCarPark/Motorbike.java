package myCarPark;

public class Motorbike extends Vehicle{
	private String engineSize;
	
	public String getType() {
		return "Motorbike";
	}
	public String getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}
	@Override
    public String toString() {
        return "Vehical Type: Motorbike, Vehical ID: " + getId() + 
                ", Vehical Brand: " + getBrand()+
                ", Engine Size: " + getEngineSize()+", Entered DateTime: "+ super.getDateTime();
    }
	
}
