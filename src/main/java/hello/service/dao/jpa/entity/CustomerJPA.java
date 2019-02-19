package hello.service.dao.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import hello.model.Customer;

@Entity
public class CustomerJPA {

    private long addressId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String email;
    private String firstName;
    private String lastName;

    public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	/**
     * @return the addressId
     */
    public long getAddressId() {
        return addressId;
    }


    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param addressId the addressId to set
     */
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }



    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Customer toCustomer() {
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setLastName(lastName);
        customer.setFirstName(firstName);
        return customer;
    }
}
