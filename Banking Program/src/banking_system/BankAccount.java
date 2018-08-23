/*
 * Model Solution for Assignment 2 - Banking System - BankAccount class
 */
package banking_system; // creating package gives an opportunity to contain related class files and allows to use short-cut class names

/*
 *	BankAccount class 
 */
public class BankAccount {

	/*
	 * fields that indicate customer,acctNum and amount and bank
	 */

	private Customer customer;
	private int acctNum;
	private double amount;
	private Bank bank;

	/*
	 * Constructor This part of program is needed to initialize the object by
	 * setting the fields to the initial values.
	 */
	public BankAccount(Bank bank, int acctNum, double amount) {
		this.bank = bank;
		this.acctNum = acctNum;
		this.amount = amount;
	}

	/*
	 * Getters and Setters
	 */
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	// =============================================================================
	
	public String getBankName() {     // return Bank name
		return bank.getBankName();
	}

	public int getBankNumber() {	// return Bank Number
		return bank.getBankNumber();
	}

	/*
	 * toString() method is used to display the results on the screen
	 */

	public String toString() {

		return getBankName() + " " + getAcctNum() + ": " + getAmount() + " usd";
	}

}
