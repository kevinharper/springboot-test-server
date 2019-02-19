package hello.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

import hello.model.Customer;
import hello.service.dao.jpa.entity.CustomerJPA;
import hello.service.dao.jpa.repository.ICustomerRepository;

@Component
@Named("HelloService")
public class JPAService {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());


    @Inject
    private ICustomerRepository customerRepository;

    private List<String> items = new ArrayList<String>();

    @Autowired
    private Tracer tracer;

    public void addItem(String item) {
        items.add(item);
    }

    public void doSomeWorkNewSpan() throws InterruptedException {
        log.info("In the original span");

        Span newSpan = tracer.createSpan("newSpan");
        try {
            Thread.sleep(1000L);
            log.info("I'm in the new span doing some cool work that needs its own span");
        }
        finally {
            tracer.close(newSpan);
        }

        log.info("Back in the original span");
    }

    public Customer getCustomer(long id) {
        CustomerJPA customerjpa = customerRepository.findOne(id);
        if(customerjpa == null) {
        	return null;
        }
    	return customerjpa.toCustomer();
    }

    public Customer getCustomerByEmail(String email) {
        log.info("Customer request by email {}", email);
        return customerRepository.findByEmail(email).toCustomer();
    }

    public Customer getCustomerByLastName(String lastName) {
        return customerRepository.findByLastName(lastName).toCustomer();
    }

    public List<String> getItems() {
        return items;
    }

    public long saveCustomer(Customer customer) {
        CustomerJPA customerJPA = Customer.toCustomerJPA(customer);
        customerRepository.save(customerJPA);
        return customerJPA.getId();
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

}
