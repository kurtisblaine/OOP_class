/*
 * Model Solution for Assignment 2 - Banking System - Main class
 */

package banking_system; // creating package gives an opportunity to contain related class files and allows to use short-cut class names

public class Main {

	// Test case objects - we make these public for easy access
	public Bank citi, wells;
	public Customer jt, rg, cb;

	// Set up Banks, Customers, Accounts
	public Main() {
		/*
		 * Declaring the variables
		 */
		citi = new Bank("Citibank", "388 Greenwich Street");
		wells = new Bank("Wells Fargo Bank", "420 Montgomery Street");

		jt = new Customer("Joe", "Tribiani");
		rg = new Customer("Rachel", "Green");
		cb = new Customer("Chandler", "Bing");

		jt.openAccount(citi, 100000.00);
		jt.openAccount(wells, 4000.0);
		jt.openAccount(citi, 50000.00);

		rg.openAccount(wells, 5000.0);
		rg.openAccount(citi, 200000.00);

		cb.openAccount(wells, 150000.00);
	}

	/*
	 * Test cases
	 */
	public void testActions1() {
		System.out.println("testActions1");

		BankAccount ba1 = jt.getAccounts()[0];
		jt.depositMoney(ba1.getBankNumber(), ba1.getAcctNum(), 100000.00);

		BankAccount ba2 = rg.getAccounts()[0];
		rg.withdrawMoney(ba2.getBankNumber(), ba2.getAcctNum(), 200.00);

		BankAccount ba3 = cb.getAccounts()[0];
		BankAccount ba4 = rg.getAccounts()[1];
		cb.transferMoney(ba3.getBankNumber(), ba3.getAcctNum(),
				ba4.getBankNumber(), ba4.getAcctNum(), 2500.00);
	}

	public void testActions2() {
		System.out.println("testActions2");

		BankAccount ba1 = rg.getAccounts()[0];
		rg.depositMoney(-100, -1000, 111111.00);     // In this case transfer money is impossible

		BankAccount ba4 = cb.getAccounts()[0];
		BankAccount ba3 = rg.getAccounts()[1];
		cb.transferMoney(ba3.getBankNumber(), ba3.getAcctNum(),
				ba4.getBankNumber(), ba4.getAcctNum(), 2500.00);
	}

	public void printCurrentState() {

		// Print out states of customers
		System.out.println(jt);
		System.out.println(rg);
		System.out.println(cb);

		// Print out states of banks
		System.out.println(citi);
		System.out.println(wells);

		// Print out all of the accounts
		for (BankAccount acct : Bank.getAllAccounts()) {
			if (acct == null) {
				break;
			}
			System.out.println(acct);
		}

		System.out.println("--------------------");
	}

	public static void main(String[] args) {

		// Set up a test case object Main
		Main testCase = new Main();

		// Make sure everything is set up correctly
		testCase.printCurrentState();

		// Go through the first set of tests
		testCase.testActions1();
		testCase.printCurrentState();

		// Go through the second set of tests (some error checking here)
		testCase.testActions2();
		testCase.printCurrentState();
	}

}