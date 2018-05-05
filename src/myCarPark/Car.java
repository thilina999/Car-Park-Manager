package myCarPark;

public class Car extends Vehicle {
	private int doors;
	private String color;
	
	public String getType() {
		return "Car";
	}

	public int getDoors() {
		return doors;
	}
	public void setDoors(int doors) {
		this.doors = doors;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
    public String toString() {
        return "Vehical Type: Car, Vehical ID: " + getId() + 
                ", Vehical Brand: " + getBrand()+
                ", Vehical Color: " + getColor()+", Entered DateTime: "+ super.getDateTime();
    }
	
}
 