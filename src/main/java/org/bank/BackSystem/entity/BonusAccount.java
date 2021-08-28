package org.bank.BackSystem.entity;

public class BonusAccount extends Account {
	
	private int scoring;
	
	public BonusAccount(int _code) {
		super(_code);
		this.scoring = 10;
	}

	public int getScoring() {
		return scoring;
	}

	public void setScoring(int scoring) {
		this.scoring = scoring;
	}
}
