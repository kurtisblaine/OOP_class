package used_car;

/*Create a UsedCarException class that extends Exception; 
 * its constructor receives a value for a vehicle 
 * identification number (VIN) that is passed to the parent 
 * constructor so it can be used in a getMessage() call.
 *  Save the class as UsedCarException.java.
 */

public class UsedCarException extends Exception {

	//Exception constructor
	public UsedCarException(String exception){
		
		//constructor calls exception constructor
		super(exception);
		
	}
}
