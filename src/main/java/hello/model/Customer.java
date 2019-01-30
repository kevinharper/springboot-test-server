package hello.model;

import hello.service.dao.jpa.entity.CustomerJPA;

public class Customer {

    private String email;
    private String firstName;
    private String lastName;

    public static CustomerJPA toCustomerJPA(Customer customer) {
        CustomerJPA customerJPA = new CustomerJPA();
        customerJPA.setEmail(customer.getEmail());
        customerJPA.setFirstName(customer.getFirstName());
        customerJPA.setLastName(customer.getLastName());
        return customerJPA;
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
}
