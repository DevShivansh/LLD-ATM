package app.model.money;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import app.constants.Action;
import app.deligates.UserAtmCard;


public class Card implements UserAtmCard{
	
	private Long accountId;
	
	private String cardNumber;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private Set<Action> actions;
	
	private Integer pin;

	public void addActions(Action[] values) {
		
		actions.addAll(Arrays.stream(values).collect(Collectors.toList()));
		
	}

	public boolean hasPermission(Action action) {
		return actions.contains(action);
	}

	public Long getAccountId() {
		return accountId;
	}
	
	@Override
	public String getCardNumber() {
		return cardNumber;
	}

	@Override
	public LocalDateTime getStartDate() {
		return startDate;
	}

	@Override
	public LocalDateTime getExpireDate() {
		return endDate;
	}

	public boolean validatePin(String pin2) {
		return this.pin == Integer.parseInt(pin2);
	}

}
