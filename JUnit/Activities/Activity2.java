package activities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccount {

	private Integer balance;

	// Create a constructor
	public BankAccount(Integer initialBalance) {
		balance = initialBalance;
	}

	// Add method to calculate
	// balance amount after withdrawal
	public Integer withdraw(Integer amount) {
		if (balance < amount) {
			throw new NotEnoughFundsException(amount, balance);
		}
		balance -= amount;
		return balance;
	}

}

class NotEnoughFundsException extends RuntimeException {

	public NotEnoughFundsException(Integer amount, Integer balance) {
		super("Attempted to withdraw " + amount + " with a balance of " + balance);
	}

}

public class Activity2 {
	
	@Test
	public void notEnoughFunds() {
		BankAccount obj= new BankAccount(10);
		assertThrows(NotEnoughFundsException.class, () -> obj.withdraw(10));
	}

	@Test
	public void enoughFunds() {
		BankAccount obj= new BankAccount(100);
		assertDoesNotThrow(() -> obj.withdraw(100));
	}
}
