package bank;

import java.math.BigDecimal;

public class PersonalAccount extends Account {

    private BigDecimal balance;
    private String customerId;

    public PersonalAccount(String customerId){
        this.balance = BigDecimal.ZERO;
        this.customerId = customerId;
    }

    @Override
    protected boolean withdraw(BigDecimal amount){
        if(balance.compareTo(amount) >= 0){
            balance = balance.subtract(amount);
            return true;
        }
        return false;
    }
    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO)>0){
            balance = balance.add(amount);
        } else {
            throw new IllegalArgumentException("Amount must be positive");
        }

    }
    @Override
    public String toString() {
         return "PersonalAccount{" +
            "balance=" + balance +
            '}';
}
    public String getId(){
        return customerId;
    }
    @Override
    public boolean isOwnedBy(String customerId) {
        return this.customerId.equals(customerId);
    }    
    
    
}
