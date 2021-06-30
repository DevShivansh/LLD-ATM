package app.model.core;

import app.constants.Action;
import app.model.dto.Response;

public class Console {

	private Screen screen;

	private Atm atm;

	public Console(Atm atm) {
		super();
		this.atm = atm;

	}

	public String displayMessage() {
		return screen.message();
	}

	public void updateScreen(String message) {
		screen.updateMessage(message);
	}

	public Response<?> performAction(Action action, String param) {

		switch (action) {
		case ENTER_PIN:
			return atm.validatePin(param);
		case WITHDRAW_CASH:
			return atm.withdraw(param);
		case DEPOSIT_CASH:
			return atm.deposit(param);
		case VIEW_STATEMENT:
			return atm.viewStatement();
		case CHECK_BALANCE:
			atm.checkBalance();
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}

	}

}
