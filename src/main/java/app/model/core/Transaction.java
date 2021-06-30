package app.model.core;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import app.constants.Action;
import app.model.dto.Response;
import app.model.user.Account;

public class Transaction {
	
	private String txnId;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private List<Action> actionsPerformed;
	
	private Account account;
	
	public Transaction(Account userAccount) {
		txnId = UUID.randomUUID().toString();
		startTime = LocalDateTime.now();
		account = userAccount;
	}

	public Response<?> addTransaction(Action action, String... params) {
		actionsPerformed.add(action);
		switch(action) {
		case WITHDRAW_CASH:
			account.debit(Double.parseDouble(params[0]));
			return new Response<Object>();
		case DEPOSIT_CASH:
			account.credit(Double.parseDouble(params[0]));
			return new Response<Object>();
		case CHECK_BALANCE:
			return new Response<Double>(account.getBalance());
			default:
				throw new RuntimeException("Action " + action + " not valid for Transaction");
		}
		
	}

	public void end() {
		endTime = LocalDateTime.now();
		
	}

	public boolean belongsToAccount(Long accountId) {
		return this.account.getAccountId() == accountId;
	}

}
