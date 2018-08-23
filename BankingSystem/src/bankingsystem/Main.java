package bankingsystem;
import java.util.Scanner;

public class Main {

	// Test case objects - we make these public for easy access
	public Bank citi, wlsfrgo, frstprmr;
	public Customer jt, rg, cb, kw;
    
    
	// Set up Banks, Customers, Accounts
	public Main() {
		
		citi = new Bank("Citibank", "388 Greenwich Street");
		wlsfrgo = new Bank("Wells Fargo Bank", "420 Montgomery Street");
		frstprmr = new Bank("First Premier Bank", "600 Avalon Ave");
		
		jt = new Customer("Joe", "Tribiani");
	    rg = new Customer("Rachel", "Green");
	    cb = new Customer("Chandler", "Bing");
	    kw = new Customer("Kurtis", "Waldner");
	    
	    jt.openAccount(citi, 100000.00);
	    jt.openAccount(wlsfrgo, 4000.0);
	    jt.openAccount(citi, 50000.00);
	    
	    rg.openAccount(wlsfrgo, 5000.0);
	    rg.openAccount(citi, 200000.00);
	    
	    cb.openAccount(wlsfrgo, 150000.00);
	}
	
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
		
        BankAccount ba1 = jt.getAccounts()[0];
        jt.depositMoney(-999, -9999, 100000.00);
        
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
        System.out.println(wlsfrgo);
        
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
		//local fields
		int choice = 0;
		long numb = 0;
	
		//create scanner
		Scanner userChoice = new Scanner(System.in);
		System.out.println("Press 1 if you would like to print a specific account's info"+
		"\nPress any other number to exit!");
		choice = userChoice.nextInt();

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
		
		do{
		switch(choice){
		case 1: System.out.println("Enter the account number you wish to access");
		choice = userChoice.nextInt();
		if(numb != choice){
			System.out.println("Please enter a correct account number next time");
			break;
			}
		else{
			System.out.println(Bank.getAllAccounts());
		}
		break;
		default: 
		break;
		}
		}
		while(choice != 1);
	}


}