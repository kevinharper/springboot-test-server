package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Customer;
import hello.service.HelloService;

@RestController
public class HelloController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Customer getCustomer() {

        return helloService.getCustomer();
    }

    @RequestMapping(value = "/new-span-for-subtask-in-same-service", method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE })
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

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer setCustomer(Customer customer) {
        helloService.setCustomer(customer);
        return helloService.getCustomer();
    }
}
