package hello.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

import hello.model.Customer;

@Component
@Named("HelloService")
public class HelloService {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    private Customer customer;

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

    public Customer getCustomer() {
        return customer;
    }

    public List<String> getItems() {
        return items;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

}
