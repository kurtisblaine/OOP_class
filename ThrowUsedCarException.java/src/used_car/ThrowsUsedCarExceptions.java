package used_car;

/*Write an application that establishes an array of at least 
 * seven UsedCar objects and handles any Exceptions. 
 * Display a list of only the UsedCar objects that were 
 * constructed successfully */

public class ThrowsUsedCarExceptions {

	public static void main(String[] args) throws UsedCarException{
		
		final int MAX_CARS = 7;
		UsedCar[] usedCar = new UsedCar[MAX_CARS];
		
		try{
			//valid
			usedCar[0] = new UsedCar("2345", "Ford", 1999, 6900, 10000);
			
			//valid
			usedCar[1] = new UsedCar("1234", "Honda", 2001, 7900, 6000);
			
			//invalid VIN
			usedCar[2] = new UsedCar("", "Chrysler", 2005, 9800, 10000);
			
			//invalid make
			usedCar[3] = new UsedCar("3456", "Aston Martin", 2007, 2000, 100000);
			
			//invalid year
			usedCar[4] = new UsedCar("4567", "Toyata", 2, 45000, 15000);
			
			//invalid mileage
			usedCar[5] = new UsedCar("5678", "Other", 2016, -6900, 11000);
			
			//invalid price
			usedCar[6] = new UsedCar("6789", "Ford", 2001, 260700, -105000);
		}
		
		catch(UsedCarException e){
	
			System.out.println(e.getMessage());
			
		}
		
	
		//if valid print successful objects
		for(int i = 0; i < usedCar.length; i++){
			
			if(usedCar[i]!=null) {
			System.out.println(usedCar[i].toString() + " is successful");
			}
			
		}
		
	}//end main
}//end class
