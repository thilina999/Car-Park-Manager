package myCarPark;

public class Van extends Vehicle{
	private int volume;
	
	public String getType() {
		return "Van";
	}
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	@Override
    public String toString() {
        return "Vehical Type: Van, Vehical ID: " + getId() + 
                ", Vehical Brand: " + getBrand()+
                ", Cargo Volume: " + getVolume()+", Entered DateTime: "+ super.getDateTime();
    }
}
