package partC_UML_Classes;
import java.util.ArrayList;
import java.util.List;


public class Manager{
    private List<Account> accounts;
    private List<Ident> idElems;

    private Manager(){
        this.accounts = new ArrayList<Account>();
		this.idElems = new ArrayList<Ident>();
    }

    public void addAccount(Account account){
        this.accounts.add(account);
        this.idElems.add(account);
    }
}