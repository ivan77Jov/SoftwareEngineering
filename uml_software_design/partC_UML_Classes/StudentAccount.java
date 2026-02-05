package partC_UML_Classes;

public class StudentAccount extends Account{

    public StudentAccount(String name) {
        super(name);
    }

    public void withDraw(double value){
        // StudentAccount can have specific logic for withdraw method
        super.withDraw(value);
    }
    
}
