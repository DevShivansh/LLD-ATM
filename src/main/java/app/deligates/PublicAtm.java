package app.deligates;

import app.model.core.Console;
import app.model.money.Card;

public interface PublicAtm {
	
	public void useAtm(Card card);
	
	public Console console();
	
	public void endTransaction();

}
