package app.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Action {

	ENTER_PIN, RETRY, WITHDRAW_CASH, DEPOSIT_CASH, CHECK_BALANCE, VIEW_STATEMENT;
	
	private static List<Action> validCardActions = new ArrayList<Action>();
	
	static {
		validCardActions.addAll(Arrays.asList(WITHDRAW_CASH, DEPOSIT_CASH, CHECK_BALANCE, VIEW_STATEMENT));
	}

	public static List<Action> validCardActions() {
		return validCardActions;
	}
}
