package app.model.user;

public class Account {

	private Long accountId;

	private String name;

	private Double balance;

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Long)
			return accountId == (Long) obj;

		return super.equals(obj);
	}
	
	public void debit(Double amount) {
		balance -= amount;
	}
	
	public void credit(Double amount) {
		balance += amount;
	}
	
	public Double getBalance() {
		return balance;
	}

	public Long getAccountId() {
		return accountId;
	}

}
