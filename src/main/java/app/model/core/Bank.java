package app.model.core;

import java.util.List;
import java.util.stream.Collectors;

import app.model.money.Card;
import app.model.user.Account;
import app.repository.AccountRepository;
import app.repository.TransactionRepository;

public class Bank {
	
	static TransactionRepository transactions = new TransactionRepository();
	
	public static Transaction startTransaction(Card activeCard) {
		Account userAccount = AccountRepository.findAccountById(activeCard.getAccountId());
		Transaction t = new Transaction(userAccount);
		transactions.add(t);
		return t;
	}

	public static List<Transaction> getLastTransactionsForAccount(Long accountId) {
		return transactions.stream().filter( t -> t.belongsToAccount(accountId)).collect(Collectors.toList());
	}

}
