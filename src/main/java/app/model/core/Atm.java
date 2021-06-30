package app.model.core;

import java.util.List;

import app.constants.Action;
import app.constants.ScreenMessage;
import app.deligates.PublicAtm;
import app.model.dto.Response;
import app.model.money.Card;
import app.model.money.Cash;
import app.model.money.CashBox;

public class Atm implements PublicAtm{

	private Console console;
	
	private Card activeCard;
	
	private Transaction activeTransaction;
	
	private CashBox cashBox;
	
	public Atm() {
		console = new Console(this);
	}
	
	@Override
	public void useAtm(Card card) {
		this.activeCard = card;
		console.updateScreen(ScreenMessage.ATM_PIN_SCREEN_MESSAGE);
	}
	
	@Override
	public Console console() {
		return console;
	}

	public Response<Boolean> validatePin(String pin) {
		
		boolean isValid = activeCard.validatePin(pin);
		if(isValid) {
			activeTransaction = Bank.startTransaction(activeCard);
			
			activeCard.addActions(Action.values());
			
			console.updateScreen( ScreenMessage.MAIN_MENU_ACTION + Action.validCardActions() );
		}else {
			console.updateScreen(ScreenMessage.INVALID_PIN_MESSAGE);
		}
		return new Response<Boolean>(isValid);
	}
	
	public Response<Cash> withdraw(String amount) {
		validatePermission(Action.WITHDRAW_CASH);
		activeTransaction.addTransaction(Action.WITHDRAW_CASH, amount);
		return new Response<Cash>(cashBox.debit(amount));
		
		
	}
	
	public Response<String> deposit(String amount) {
		validatePermission(Action.DEPOSIT_CASH);
		activeTransaction.addTransaction(Action.DEPOSIT_CASH, amount);
		cashBox.credit(amount);
		return new Response<String>(ScreenMessage.DEPOSIT_SUCCESSFUL); 
	}
	
	
	public Response<Integer> checkBalance() {
		validatePermission(Action.CHECK_BALANCE);
		int balance = (Integer) activeTransaction.addTransaction(Action.CHECK_BALANCE).res;
		return new Response<Integer>(balance);
	}
	
	public Response<List<Transaction>> viewStatement() {
		validatePermission(Action.VIEW_STATEMENT);
		return new Response<>(Bank.getLastTransactionsForAccount(activeCard.getAccountId()));
	}
	
	public void validatePermission(Action action) {
		if( !activeCard.hasPermission(action))
			throw new RuntimeException("Card does not have permission to " + action.name());
	}
	
	@Override
	public void endTransaction() {
		activeTransaction.end();
		activeTransaction = null;
		activeCard.removeActions(Action.validCardActions());
		activeCard = null;
	}
	
}
