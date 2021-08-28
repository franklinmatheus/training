package org.bank.BackSystem.entity;

public class SavingsAccount extends Account {

	public SavingsAccount(int _code) {
		super(_code);
	}
	
	/*
	 * ratio: [0,100] 
	 */
	public void earnInterest(double ratio) {
		this.setBalance(this.getBalance() + (this.getBalance() * (ratio/100)));
	}
}
