package org.bank.BackSystem.entity;

public class Account {
	
	private int code;
	private double balance;
	
	public Account(int _code) {
		this.code = _code;
		this.balance = 0;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int _code) {
		this.code = _code;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double _balance) {
		this.balance = _balance;
	}
}
