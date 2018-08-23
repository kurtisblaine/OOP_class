package bankingsystem;

public class Customer {
	//fields and constants
	public static final int MAX_ACCTS = 10;
    private String firstName;
    private String lastName;
    private String address;
    private BankAccount[] accounts = new BankAccount[MAX_ACCTS];
    //end fields and constants

//start getters and setters
public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public BankAccount[] getAccounts() {
	return accounts;
}

public void setAccounts(BankAccount[] accounts) {
	this.accounts = accounts;
}
//end getters and setters

public Customer(String fName, String lName){//constructor

			firstName = fName;
			lastName = lName;
			
		System.out.printf("Customer Information: %s\n", this);
		}	

public void openAccount(Bank b, double amount){
	//set the array to the new bank account
	accounts[0] = new BankAccount(b, b.getBankNumber(), amount);
	accounts[1] = new BankAccount(b, b.getBankNumber(), amount);
	
	System.out.println("The account was opened successfully!\n" + "-----printing-----\n" +
	getFirstName() + " " + getLastName() + " " + b + " Amount: " + amount + "\n-------------------");
}

public void transferMoney(int fromBankNum, int fromAcctNum, 
int toBankNum, int toAcctNum, double amount){
	//account for the user transferring money to same account
	if(fromBankNum == toBankNum || fromAcctNum == toAcctNum){
		System.out.println("You cannot transfer to the same account!");
	}
	else{
		System.out.println("The amount of " + amount + " from account number " + fromAcctNum + " to account number "
				+ toAcctNum + " was transffered successfully!");
	}
}

public void withdrawMoney(int fromBankNum, int fromAcctNum, 
double amount){
	//subtracting currency and adding to amount
	if(amount > 0 && fromBankNum == fromAcctNum){
		System.out.println("The amount withdrawn from " +
	fromBankNum + " with the amount of " + amount + " was successfull!");
	}
	else{
		//accounting for negative value
		System.out.println("The amount withdrawn should be positive.");
	}
}

public void depositMoney(int toBankNum, int toAcctNum, 
		double amount){
	if(amount < 0 || toBankNum == toAcctNum){
	//adding currency and adding to amount
	System.out.println("The amount of " + amount +
	" was deposited successfully!");
		}
		else{
			//accounting for negative value
			System.out.println("The amount deposited should be positive or the bank accounts should match your accounts.");
		}
	}	

//toString method testing implementation
	public String toString(){
		return String.format("%s %s", firstName, lastName);
	}
	
}//end class