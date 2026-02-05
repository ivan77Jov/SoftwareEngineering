package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CorporateAccount extends Account {

    private BigDecimal balance;
    private List<String> customerIds;

    public CorporateAccount(List<String> customerIds) {
        this.balance = BigDecimal.ZERO;
        this.customerIds = new ArrayList<>(customerIds);
    }

    @Override
    protected boolean withdraw(BigDecimal amount){
        balance = balance.subtract(amount);
        return true;
    }
    @Override
    public BigDecimal getBalance(){
        return balance;
    }
    public void deposit(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO)>0){
        balance = balance.add(amount);
        }else{
           throw new IllegalArgumentException("Amount must be positive");
        }
    }
    public List<String> getCustomerIds(){
        return customerIds;
    }

    @Override
    public String toString() {
        return "CorporateAccount{" +
            "balance=" + balance +
            ", customerIds=" + customerIds +
            '}';
}   @Override
    public boolean isOwnedBy(String customerId) {
        return customerIds.contains(customerId);
}


    
}
