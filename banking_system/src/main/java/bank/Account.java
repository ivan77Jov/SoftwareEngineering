package bank;

import java.math.BigDecimal;

/**
 * A bank account. This is an abstract base class for
 * <code>PersonalAccount</code> and <code>CorporateAccount</code>.
 * 
 */
public abstract class Account {
	BigDecimal balance;
	String aid;


	/**
	 * Withdraws the given amount from the account's balance.
	 * 
	 * @param amount the amount to withdraw
	 * @return boolean true iff the withdraw operation was successful
	 */
	protected abstract boolean withdraw(BigDecimal amount);
	public abstract boolean isOwnedBy(String customerId);

	/**
	 * @return the balance of the account
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	public void deposit(BigDecimal amount){
		if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
			throw new IllegalArgumentException("Amount to deposit must be positive");
		}
		balance = balance.add(amount);
	}
	public String getId(){
		return aid;
	}

	@Override
    public String toString() {
        return "Account{" +
            "balance=" + balance +
            '}';
}




}
