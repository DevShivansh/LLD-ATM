package app.model.user;

import app.deligates.UserAtmCard;
import app.model.money.Cash;
import app.model.money.Wallet;

public class User {
	
	private UserAtmCard card;
	
	private String atmPin;
	
	private Wallet wallet;
	
	public void addCash(Cash cash) {
		wallet.addCash(cash);
	}

}
