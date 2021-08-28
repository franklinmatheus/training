package org.bank.BackSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.bank.BackSystem.control.BankSystem;
import org.bank.BackSystem.entity.BonusAccount;
import org.bank.BackSystem.entity.SavingsAccount;

public class BankSystemTest {
    
	@Test
	public void register() {
		BankSystem bankSystem = new BankSystem();
		bankSystem.register(1);
		assertTrue(bankSystem.getAccount(1) != null);
	}
	
	@Test
	public void credit() {
		BankSystem bankSystem = new BankSystem();
		bankSystem.register(1);
		bankSystem.credit(1, 1000);
		assertTrue(bankSystem.getAccount(1).getBalance() == 10090);
	}
	
	@Test
	public void debit() {
		BankSystem bankSystem = new BankSystem();
		bankSystem.register(1);
		bankSystem.debit(1, 10);
		assertTrue(bankSystem.getAccount(1).getBalance() == -10);
	}
	
	@Test
	public void creditThenDebid() {
		BankSystem bankSystem = new BankSystem();
		bankSystem.register(1);
		bankSystem.credit(1, 900);
		bankSystem.debit(1, 350);
		assertTrue(bankSystem.getAccount(1).getBalance() == 550);
	}
	
	@Test
	public void transfer() {
		BankSystem bankSystem = new BankSystem();
		bankSystem.register(1);
		bankSystem.register(2);
		bankSystem.transfer(1, 2, 200);
		assertTrue(bankSystem.getAccount(1).getBalance() == -200);
		assertTrue(bankSystem.getAccount(2).getBalance() == 200);
	}
	
	@Test
	public void earnInterest() {
		BankSystem bankSystem = new BankSystem();
		SavingsAccount account = new SavingsAccount(1);
		bankSystem.register(account);
		account.setBalance(100);
		bankSystem.earnInterest(1, 15);
		assertTrue(bankSystem.getAccount(1).getBalance() == 115);
	}
	
	@Test
	public void bonusCredit() {
		BankSystem bankSystem = new BankSystem();
		BonusAccount account = new BonusAccount(1);
		bankSystem.register(account);
		bankSystem.credit(1, 500);
		assertTrue(((BonusAccount) bankSystem.getAccount(1)).getScoring() == 15);
	}
	
	@Test
	public void bonusTransfer() {
		BankSystem bankSystem = new BankSystem();
		BonusAccount account = new BonusAccount(1);
		bankSystem.register(account);
		bankSystem.register(2);
		bankSystem.transfer(2, 1, 550);
		assertTrue(((BonusAccount) bankSystem.getAccount(1)).getScoring() == 13);
	}
}
