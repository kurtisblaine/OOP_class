/*
 * Model Solution for Assignment 2 - Banking System - Bank class
 */
package banking_system; // creating package gives an opportunity to contain related class files and allows to use short-cut class names

/*
 * Bank Class
 */
public class Bank {

	/*
	 * fields that indicate the bank's name, bank number and address and array
	 * of allAccounts
	 */

	private String bankName;
	private int bankNumber;
	private String address;
	private static BankAccount[] allAccounts = new BankAccount[1000];

	/*
	 * these fields created in order to keep in track the amount of account
	 * number and bank number
	 */

	private int accountNumber = 1; // it should start from 1 for each bank
	private static int currentBankNumber = 1; // static variables in order to
												// initialize once

	/*
	 * Constructor This part of program is needed to initialize the object by
	 * setting the fields to the initial values. In our case we define name,
	 * address and set the value for bankNumber.
	 */
	public Bank(String name, String address) {
		this.bankName = name;
		this.address = address;
		bankNumber = currentBankNumber;
		currentBankNumber++;
	}

	// ====================================================================================================
	/*
	 * Getters and Setters
	 */
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(int bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static BankAccount[] getAllAccounts() {
		return allAccounts;
	}

	public static void setAllAccounts(BankAccount[] allAccounts) {
		Bank.allAccounts = allAccounts;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public static int getCurrentBankNumber() {
		return currentBankNumber;
	}

	public static void setCurrentBankNumber(int currentBankNumber) {
		Bank.currentBankNumber = currentBankNumber;
	}

	// ====================================================================================================

	/*
	 * In this part of code, it is created account
	 */
	
	public BankAccount createAccount(Customer customer, double amount) {

		int i = 0;
		boolean t = false;
		BankAccount newAccount = new BankAccount(this, accountNumber, amount);
		for (i = 0; i < allAccounts.length; i++) {
			if (allAccounts[i] == null) {                   // if account is empty we can create account
				allAccounts[i] = newAccount;
				t = true;
				break;                                  // we use it to create only one account per each time when we call createAccount() method  
			}
		}
		if (t == false) {                         // t=false, no account can be created anymore 
			return null;
		}
		accountNumber++;
		return allAccounts[i];                    
	}

	/*
	 * toString() method is used to display the results on the screen 
	 */
	
	public String toString() {

		String result = this.getBankName() + " " + this.getBankNumber() + "\n";

		if (!this.getAddress().isEmpty()) {
			result = result + this.getAddress() + "\n";
		}

		return result;
	}

}
