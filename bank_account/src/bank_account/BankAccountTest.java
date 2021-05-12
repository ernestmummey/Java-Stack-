package bank_account;


public class BankAccountTest {
 
		public static void main(String[] args) {
		        BankAccount person1 = new BankAccount();
//		        BankAccount person2 = new BankAccount();
//		        BankAccount person3 = new BankAccount();

		        person1.getCheckingBalance();
		        person1.getSavingBalance();
		        person1.deposit(1000.0, "saving");
		        person1.deposit(300.0, "checking");
		        person1.withdraw(100.0, "saving");
		        person1.withdraw(100.0, "checking");
		        person1.acctBalance(person1.getAccountNumber());
			
			
		}
}
