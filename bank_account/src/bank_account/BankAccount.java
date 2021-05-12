package bank_account;
import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingBalance;
	
	private static int numberOfAccounts = 0;
	private static int totalMoney = 0;
	
	public BankAccount() {
		this.accountNumber = generateAccountNum();
		this.checkingBalance = 0.0;
		this.savingBalance = 0.0;
		numberOfAccounts++;
		
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public Double getCheckingBalance() {
		return checkingBalance;
	}

	public Double getSavingBalance() {
		return savingBalance;
	}
	
	//depositing money
	public void deposit(double amountDeposit, String account) {
		if(account.equals("checking")) {
			this.checkingBalance += amountDeposit;
			System.out.printf("Deposit %.2f into %s. New total is %s\n", amountDeposit, this.getAccountNumber(), getCheckingBalance());
			
		}
		else if(account.equals("saving")) {
			this.savingBalance += amountDeposit;
			System.out.printf("Deposit %.2f into %s. New total is %s\n", amountDeposit, this.getAccountNumber(), getSavingBalance());
		}
		else {
			System.out.println("Please enter checking or saving");
		}
		totalMoney += amountDeposit;
	}
	
	//withdraw money
	 public void withdraw(double amountWithdraw, String account) {
	        if (account.equals("checking")) {
	            if (this.checkingBalance - amountWithdraw >= 0) {
	                this.checkingBalance -= amountWithdraw;
	    			System.out.printf("Deposit %.2f into %s. New total is %s\n", amountWithdraw, this.getAccountNumber(), getCheckingBalance());
	            } else {
	                System.out.println("Insufficient funds.");
	                return;
	            }
	        } else if (account.equals("checking")) {
	            if (this.savingBalance - amountWithdraw >= 0) {
	                this.savingBalance -= amountWithdraw;
	    			System.out.printf("Deposit %.2f into %s. New total is %s\n", amountWithdraw, this.getAccountNumber(), getSavingBalance());
	            } else {
	                System.out.println("Insufficient funds.");
	                return;
	            }
	        } else {
	            System.out.println("Invalid account type. Please enter either saving or checking.");
	        }

	        totalMoney += amountWithdraw;
	    }
	 
	 
	 
	 
	 // method for total money
	 public void acctBalance(String account) {
	        System.out.printf("Total balance of account# %s is $%.2f\n", 		 this.getAccountNumber(),this.savingBalance + this.checkingBalance);
	    }
	
	 
	 
	 //Generate random account number
	private static String generateAccountNum() {
		String randStr = "";
		Random rand = new Random();
		for(int i = 0; i < 10; i++) {
			randStr += rand.nextInt(10);
		}
		
		return randStr;
	}

	

}
