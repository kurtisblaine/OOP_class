package used_car;

/*Create a UsedCar class with fields for VIN, make, year, mileage, and price. The UsedCar constructor throws a UsedCarException
 when the VIN is not four digits; when the make is not Ford, Honda, Toyota, Chrysler, or Other; when the year is not 
 between 1990 and 2014 inclusive; or either the mileage or price is negative.
 */

public class UsedCar {
	
	//fields
	private int year;
	private double price, mileage; 
	private String make, vin; 
	
	public UsedCar(String vin, String make, int year, double mileage, double price) throws UsedCarException{
		
		// length is not 4 digits
		if(vin.length() != 4){
		//new used car exception
		throw new UsedCarException("An error has occured on one or more used car creations!");
		}
		
		// make is not of type vehicle
		if((!make.equals("Ford")) && (!make.equals("Honda")) &&
		(!make.equals("Toyata")) && (!make.equals("Chrysler"))
		&& (!make.equals("Other"))){
		//new used car exception
		throw new UsedCarException("Exception: Invalid make");
		}
		
		//<1990 or >2014
		if(year < 1990 || year > 2014){
		//new used car exception
		throw new UsedCarException("Exception: Invalid year");
		}
		
		// mileage is negative
		if(mileage < 0){
		//new used car exception
		throw new UsedCarException("Exception: Mileage is negative");
		}
		
		//price is negative
		if(price < 0){
		//new used car exception
		throw new UsedCarException("Exception: Price is negative");
		}
		
		//set fields
		this.vin = vin;
		this.make = make;
		this.year = year;
		this.mileage = mileage;
		this.price = price;
		
	}//end constructor
	
	
	@Override
	
	//toString method of UsedCar
	public String toString(){
		return vin + " " + make + " " + year + " " + mileage + " " + price;
	}//end toString
	
}
