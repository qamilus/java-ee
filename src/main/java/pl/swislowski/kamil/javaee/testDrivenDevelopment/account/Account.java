package pl.swislowski.kamil.javaee.testDrivenDevelopment.account;

public class Account {

	private Double balance = 0.0;
	
	public Account() {
		
	}

	public Account(Double balance) {
		this.balance = balance;
	}


	public Double getBalance() {

		return balance;
	}


	public Double withdraw(Double amount) {

		return balance -= amount;
	}


	public Double deposit(Double amount) {

		return balance += amount;
	}

}
