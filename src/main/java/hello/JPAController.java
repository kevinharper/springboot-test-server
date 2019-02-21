package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Customer;
import hello.service.CustomerService;

@RestController
public class JPAController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CustomerService helloService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomer(@RequestParam(value = "email", required = false) String email, @RequestParam(value = "lastName", required = false) String lastName) {
        if (email == null && lastName == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else if (email != null) {

            return new ResponseEntity<Customer>(helloService.getCustomerByEmail(email), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Customer>(helloService.getCustomerByLastName(lastName), HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") long id) {
    	return helloService.getCustomer(id);
    }
    
    
    
    @RequestMapping(value = "/new-span-for-subtask-in-same-service", method = RequestMethod.GET)
    public String newSpanInSameServiceDemo() {
        try {
            helloService.doSomeWorkNewSpan();
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Greetings from The original microservice";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<Long> saveCustomer(Customer customer) {
        if (customer.getFirstName() == null & customer.getLastName() == null && customer.getEmail() == null) {
            log.debug("Can't save a customer without first, last, email");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Long>(helloService.saveCustomer(customer), HttpStatus.OK);
    }
}
