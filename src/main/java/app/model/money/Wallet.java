package app.model.money;

import java.util.HashMap;
import java.util.Map;

import app.constants.Currency;

public class Wallet {

	private Map<Currency, Integer> cashMap = new HashMap<>();
	
	
	public void addCash(Cash cash) {
		cashMap.putIfAbsent(cash.currency(), 0);
		cashMap.put(cash.currency(), cashMap.get(cash.currency()) + cash.getCount());
	}
}
