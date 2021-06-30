package app.deligates;

import java.time.LocalDateTime;

public interface UserAtmCard {

	public String getCardNumber();
	
	public LocalDateTime getStartDate();
	
	public LocalDateTime getExpireDate();
}
