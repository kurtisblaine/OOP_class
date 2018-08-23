/*
 * Model Solution for Assignment 2 - Banking System - Customer class
 */

/* creating a package gives an opportunity to contain related
 *  class files and allows to use short-cut class names
 */
package banking_system;

/*
 * Customer class
 */
public class Customer {

	/*
	 * fields that indicate the client's name,surname and address and array of
	 * accounts
	 */
	private String firstName;
	private String lastName;
	private String address;
	private BankAccount[] accounts = new BankAccount[MAX_ACCTS];

	public static final int MAX_ACCTS = 10; // Constant variable

	/*
	 * Constructor This part of program is needed to initialize the object by
	 * setting the fields to the initial values. In our case we define name,
	 * surname and set the address to "".
	 */
	public Customer(String fName, String lName) {
		this.firstName = fName;
		this.lastName = lName;
		this.address = new String();
	}

	// =====================================================================================================
	/*
	 * Getters and Setters 
	 */
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

	public static int getMaxAccts() {
		return MAX_ACCTS;
	}

	// ===================================================================================================

	/*
	 * Our first helper method where we look through all accounts of one customer
	 */
	
	private BankAccount checkerLocalAccnt(int bankNum, int acctNum) {
		for (int i = 0; i < MAX_ACCTS; i++) {
 			if (accounts[i] != null && accounts[i].getAcctNum() == acctNum                    // If account is not empty and bank number and account number is the same  
					&& bankNum == accounts[i].getBankNumber()) {							  // for the current client, return account 
				return accounts[i];
			}

		}
		return null;                         // if there are no accounts of current client 
	}
	/*
	 * Our second helper method where we look through ALL existing accounts
	 * The idea is the same as first helper method
	 */
	private BankAccount checkerAllAccnt(int bankNum, int acctNum) {
		for (int i = 0; i < Bank.getAllAccounts().length; i++) {
			if (Bank.getAllAccounts()[i] != null
					&& Bank.getAllAccounts()[i].getAcctNum() == acctNum
					&& bankNum == Bank.getAllAccounts()[i].getBankNumber()) {
				return Bank.getAllAccounts()[i];
			}
		}
		return null;
	}
	/*
	 * 		In here client open accounts 
	 */
	public void openAccount(Bank b, double amount) {
		boolean t = false;
		for (int i = 0; i < MAX_ACCTS; i++) {
			if (accounts[i] == null) {								// if account is empty we can open account by calling createAccount() method
				accounts[i] = b.createAccount(this, amount);                   
				t = true; 
				break; 												//we use it to create only one account per each time when we call openAccount() method  
			}
		}
		if (t == false) {
			System.out.println("No account can be created!");
		}
	}
/*
 *  Transfer money account
 */
	public void transferMoney(int fromBankNum, int fromAcctNum, int toBankNum,
			int toAcctNum, double amount) {

		BankAccount accountsFrom = checkerLocalAccnt(fromBankNum, fromAcctNum);       // refers to 1- helper method 
		BankAccount accountsTo = checkerAllAccnt(toBankNum, toAcctNum);               // refers to 2- helper method

		if (accountsTo != null && accountsFrom != null) {
			accountsFrom.setAmount(accountsFrom.getAmount() - amount);
			accountsTo.setAmount(accountsTo.getAmount() + amount);
		} else
			System.out.println("Transfor money cannot be executed.");
	}
/*
 * Withdraw money
 */
	public void withdrawMoney(int fromBankNum, int fromAcctNum, double amount) {

		BankAccount accounts = checkerLocalAccnt(fromBankNum, fromAcctNum);  // refers to 1- helper method

		if (accounts != null && accounts.getAmount() >= amount) {
			accounts.setAmount(accounts.getAmount() - amount);
		} else
			System.out
					.println("The account cannot be found or the amount of money is bigger than balance on the account.");
	}
/*
 * Deposit money
 */
	public void depositMoney(int toBankNum, int toAcctNum, double amount) {

		BankAccount accounts = checkerLocalAccnt(toBankNum, toAcctNum);   // refers to 1- helper method
		if (accounts != null) {
			accounts.setAmount(accounts.getAmount() + amount);
		} else
			System.out.println("Account does not exist");

	}

	/*
	 * toString() method is used to display the results on the screen
	 */

	public String toString() {

		String result = this.getFirstName() + " " + this.getLastName() + "\n";

		if (!this.getAddress().isEmpty()) {
			result = result + this.getAddress() + "\n";
		}

		for (int k = 0; k < this.getAccounts().length
				&& this.getAccounts()[k] != null; k++) {
			BankAccount acct = this.getAccounts()[k];
			result = result + acct + "\n";
		}
		return result;
	}

}
