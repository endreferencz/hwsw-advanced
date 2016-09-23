package com.epam.training.command;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Accounting {

	private Map<String, BigDecimal> accounts = new HashMap<String, BigDecimal>();

	public BigDecimal getBalance(String account) {
		return accounts.get(account);
	}

	public void addBookEntry(String account, BigDecimal amount) {
		if (accounts.containsKey(account)) {
			BigDecimal balance = accounts.get(account);
			balance = balance.add(amount);
			accounts.put(account, balance);
		} else {
			accounts.put(account, amount);
		}
	}

	public void cancelBookEntry(String account, BigDecimal amount) {
		if (!accounts.containsKey(account)) {
			throw new IllegalStateException("Missing account");
		} else {
			BigDecimal balance = accounts.get(account);
			balance = balance.subtract(amount);
			accounts.put(account, balance);
		}
	}

}
