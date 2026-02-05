package bank;

import java.util.Date;
import java.util.UUID;

/**
 * A customer. Customers are identified by a unique id.
 *
 */
public class Customer {


	private String firstName;
	private String lastName;
	private Date birthDay;
	private String id;

	public Customer(String firstName, String lastName, Date birthDay) {
		if(firstName == null || lastName == null || birthDay == null){
			throw new IllegalArgumentException("Fields cannot be null");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.id = UUID.randomUUID().toString();
		
	}

	/**
	 * @return the first name of this customer
	 */
	protected String getFirstName() {
		return firstName;
	}

	/**
	 * @return the last name of this customer
	 */
	protected String getLastName() {
		return lastName;
	}

	/**
	 * @return the birthday of this customer
	 */
	protected Date getBirthDay() {
		return birthDay;
	}
	
	protected String getId(){
		return id;
	}

	@Override
    public String toString() {
        return "Customer{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", birthDay=" + birthDay +
            ", id='" + id + '\'' +
            '}';
}

}
