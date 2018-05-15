package myCarPark;

import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterCarParkManager extends Vehicle implements CarParkManager {
	
	public static void main(String[] args){
		WestminsterCarParkManager carPark=new WestminsterCarParkManager();
		
		carPark.main();
	}
	
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Vehicle> al= new ArrayList<Vehicle>();
	ArrayList<Vehicle> alview= new ArrayList<Vehicle>();
	int NumOfVehicles = 0;
	int filledLots = 0;
	int nofcars=0 ;
	int nofvans=0;
	int nofbikes=0;
	int totalVehicles =0;
	int parkedTime;
	
	
	public void main() {
		System.out.println("			++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("			+++++  Westminster Car Park Manager  +++++");
		System.out.println("			++++++++++++++++++++++++++++++++++++++++++");
		// Display Current date and time
				
		
		boolean value = true;
			while (value) {
				
				display();
			
				System.out.print("Select Your Option: ");
				String optionMenu = sc.next().toUpperCase();
				switch (optionMenu) {
					case "A":
						addVehicle();
										break;
					
					case "V":
						viewAllSlots();
										break;
					
					case "D":
						DeleteVehicle();
										break;

					case "S":
						viewStatistics();
										break;

					case "P":
				/*Print the list of vehicle, which enter in the parking in a specified day: the user
				has to enter the day and year from the console and the list of the vehicles that
				entered that day will be printed. A message will notify if no vehicles were
				parked in that day.*/
						System.out.println("Enter the Date : DD MM YYYY");
						int searchDay = sc.nextInt();
						int searchMonth = sc.nextInt();
						int searchYear = sc.nextInt();
						try{
						int count =0;
						for(Vehicle vehicleObj3:al){
							if(vehicleObj3.getDateTime().getDay()==searchDay && vehicleObj3.getDateTime().getMonth()==searchMonth && vehicleObj3.getDateTime().getYear()==searchYear){
								System.out.println(vehicleObj3);
								count++;
							}
						}	
						if(count==0){
							System.out.println("No Vehicles Found ");
						}
								
						}catch(Exception e){
							System.out.println(e);
						}
										
										break;

					case "Q":
						close();
										break;

				}
			}

}
	
	public void display(){
		System.out.println("\n");		
		System.out.println("			              Menu              ");
		System.out.println("			A : Add a vehicle to car park");
		System.out.println("			D : Delete vehicle from the car park");
		System.out.println("			V : View all vehicles in the park");		
		System.out.println("			S : View statistics");
		System.out.println("			P : Print the list of vehicles, on a specified day");
		System.out.println("			Q : Exit");
	
	}

	public void addVehicle() {
		if(filledLots==5){
			System.out.println("Car Park is Full");	
		}else{
		
		System.out.print("Please enter vehicle Type - Car(C) | Van(V) | Motorbike(M): ");
		String vehicleType = sc.next();		
	
		if(vehicleType.equalsIgnoreCase("Car")||vehicleType.equalsIgnoreCase("C")){	
			Vehicle car = new Car();
			
			System.out.print("Enter Date - eg:- DD MM YYYY: ");
			int day = sc.nextInt();
			int month = sc.nextInt();
			int year = sc.nextInt();
			System.out.print("Enter Time eg:- HH MM ");
			int hours = sc.nextInt();
			int minutes = sc.nextInt();
			DateTime enterTime = new DateTime(day,  month,  year, hours,  minutes);
			car.setDateTime( enterTime);
			
			System.out.print("Enter Vehical ID : ");
			String id = sc.next();
			System.out.print("Enter Vehical Brand : ");
			String brand = sc.next();			
			
			System.out.print("Enter Number of Doors in the Car : ");	
			int doors = sc.nextInt();
			System.out.print("Enter the color of the Car : ");	
			String color = sc.next();	
			
				car.setId(id);
				car.setBrand(brand);
				((Car) car).setDoors(doors);
				((Car) car).setColor(color);
				al.add(car);
				System.out.println("\nSuccesfully added to the Car Park");
				filledLots++;
				nofcars++;
			}else if(vehicleType.equalsIgnoreCase("Motorbike")||vehicleType.equalsIgnoreCase("M")){
				Vehicle motorbike = new Motorbike();
				
				System.out.print("Enter Date - eg:- DD MM YYYY: ");
				int day = sc.nextInt();
				int month = sc.nextInt();
				int year = sc.nextInt();
				System.out.print("Enter Time eg:- HH MM ");
				int hours = sc.nextInt();
				int minutes = sc.nextInt();
				DateTime enterTime = new DateTime(day,  month,  year, hours,  minutes);
				motorbike.setDateTime( enterTime);
				
				System.out.print("Enter Vehical ID : ");
				String id = sc.next();
				System.out.print("Enter Vehical Brand : ");
				String brand = sc.next();				
				
				System.out.print("Enter the Engine size of the Motorbike (CC): ");	
				String engineSize = sc.next();	
					motorbike.setId(id);
					motorbike.setBrand(brand);
					((Motorbike) motorbike).setEngineSize(engineSize);
					al.add(motorbike);
					System.out.println("\nSuccesfully added to the Car Park");
				filledLots++;
				nofbikes++;
			}else if(vehicleType.equalsIgnoreCase("Van")||vehicleType.equalsIgnoreCase("V")){
				if(filledLots!=19){
					Vehicle van = new Van();
					
					System.out.print("Enter Date - eg:- DD MM YYYY: ");
					int day = sc.nextInt();
					int month = sc.nextInt();
					int year = sc.nextInt();
					System.out.print("Enter Time eg:- HH MM ");
					int hours = sc.nextInt();
					int minutes = sc.nextInt();
					DateTime enterTime = new DateTime(day,  month,  year, hours,  minutes);
					van.setDateTime( enterTime);
					
					System.out.print("Enter Vehical ID : ");
					String id = sc.next();
					System.out.print("Enter Vehical Brand : ");
					String brand = sc.next();				
					
					System.out.print("Enter Cargo volume (Kg) : ");	
					int volume = sc.nextInt();	
						
						van.setId(id);
						van.setBrand(brand);
						((Van) van).setVolume(volume);
						al.add(van);
						System.out.println("\nSuccesfully added to the Car Park");
					filledLots = filledLots+2;
					nofvans++;
				}else {
					 System.out.println("\n Not enough space in the Car Park ");
				}
			}

		System.out.println("No of free lots remaining: "+(5-filledLots) ); 
		}
	}

	public void DeleteVehicle() {
		System.out.print("Enter the Vehicle ID ");
		String vehicleID = sc.next();
		try{
		for(Vehicle vehicleObj:al){	
			if(vehicleObj.getId().equalsIgnoreCase(vehicleID)){
				
				System.out.print("Enter Date - eg:- DD MM YYYY: ");
				int day = sc.nextInt();
				int month = sc.nextInt();
				int year = sc.nextInt();
				System.out.print("Enter Time eg:- HH MM ");
				int hours = sc.nextInt();
				int minutes = sc.nextInt();
				DateTime eixtTime = new DateTime(day,  month,  year, hours,  minutes);
				vehicleObj.setExitDateTime( eixtTime);
				
				al.remove(vehicleObj);
				System.out.println("Vehicle removed from Carpark; Vehicle Type: "+vehicleObj.getType()+" Exit DateTime: "+vehicleObj.getExitDateTime());
				charge(vehicleObj);
				if(vehicleObj.getType()=="Van"){
					filledLots=filledLots-2;
					nofvans--;
				}else if(vehicleObj.getType()=="Car"){
					filledLots=filledLots-1;
					nofcars--;
				}else if(vehicleObj.getType()=="Motorbike"){
					filledLots=filledLots-1;
					nofbikes--;
				}
				System.out.println("\nNO of free lots remaining: "+(5-filledLots) );
			}
		}
		}catch(Exception e){}
		
	}

	public void viewAllSlots() {
		for(Vehicle vehicleObj:al){
			System.out.println(vehicleObj);	
		}
	}

	public void viewStatistics() {
		System.out.println("No of free lots remaining: "+(5-filledLots) );		
		totalVehicles =nofcars+nofvans+nofbikes;
		if(totalVehicles != 0){
			System.out.println("NO of Cars : " +nofcars );
			System.out.println("NO of Vans : " +nofvans );
			System.out.println("NO of Motorbikes : " +nofbikes );
		
			double pcars = (100*nofcars)/(double)totalVehicles;
			double pvans = (100*nofvans)/(double)totalVehicles;
			double pmotorbike =(100* nofbikes)/(double)totalVehicles;
			
			System.out.println("Percentage of Cars : " +Math.round(pcars*100.0)/100.0 +"%" );
			System.out.println("Percentage of Vans : " +Math.round(pvans*100.0)/100.0 +"%");
			System.out.println("Percentage of Motorbikes : " +Math.round(pmotorbike*100.0)/100.0 +"%");
		}else{
			System.out.println("Car park is empty" );
		}
//		for(Vehicle vehicleObj:al){
//			parkedTime(vehicleObj);
//			
//			/*The vehicle that is parked for the longest time and the last vehicle that
//was parked. You should show the ID plate, the type and the entry time
//and date for these two vehicles.*/
//		}
	}
	public int parkedTime(Vehicle vehicleObj) {
		int enteredYear= vehicleObj.getDateTime().getYear()*60*24*30*12;
		int enteredMonth= vehicleObj.getDateTime().getMonth()*60*24*30;
		int enteredDay= vehicleObj.getDateTime().getDay()*60*24;
		int enteredHour= (vehicleObj.getDateTime().getHours())*60;
		int enteredMinutes= vehicleObj.getDateTime().getMinutes();
		int enteredTime  = enteredYear+enteredMonth+enteredDay+enteredHour+enteredMinutes;
		
		int exitYear= vehicleObj.getExitDateTime().getYear()*60*24*30*12;
		int exitMonth= vehicleObj.getExitDateTime().getMonth()*60*24*30;
		int exitDay= vehicleObj.getExitDateTime().getDay()*60*24;
		int exitHour= vehicleObj.getExitDateTime().getHours()*60;
		int exitMinutes= vehicleObj.getExitDateTime().getMinutes();
		int exitTime= exitYear+exitMonth+exitDay+exitHour+exitMinutes;
		
		 parkedTime= exitTime-enteredTime ;
		return parkedTime;
	}
	public void charge(Vehicle vehicleObj) {
		parkedTime(vehicleObj);
		int charge;
		if((parkedTime)<=(60*3)){
			charge = (parkedTime/60)*3;
		}else if((parkedTime>60*3)&&(parkedTime<60*24)){
			
			charge = 9+(parkedTime-(60*3))/60;
			
		}else{
			charge = (parkedTime/(60*24))*30;
		}
		
		System.out.println("\nCharging for the time is = "+charge+"£");
	}
	public void close() {
		System.out.println("Thank You For Using The Car Park Sysetm !!" );
		System.exit(0);
	}

	
	@Override
	public String getType() {
		return "Vehicle Type";
	}

  
}
