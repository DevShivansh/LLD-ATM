package app.model.money;

import app.constants.Currency;

public class Cash {

	private Currency currency;
	
	private Integer count;

	public Currency currency() {
		return currency;
	}
	
	public Integer getCount() {
		return count;
	}
}
