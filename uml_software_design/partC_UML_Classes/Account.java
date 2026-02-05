package partC_UML_Classes;

public class Account implements Ident {

    private static int AccountCounts = 0;
    private String name;
    private double money;
    private Manager manager;

    public Account(String name){
        this.name = name;
        this.money = 0.0;
        AccountCounts++;
    }

    @Override
    public long getID(){
        return this.hashCode();
    }

    public void deposit(double value) {
        this.money += value;
    }

    public void withDraw(double value) {
        if (this.money >= value) {
            this.money -= value;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getAccCount(){
        return Account.AccountCounts;
    } //useless

    public Manager getManager() {
        return manager;
    }


}
