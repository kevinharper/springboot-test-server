package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.service.HelloService;

@RestController
public class HelloController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private HelloService helloService;

    @RequestMapping("/customer")
    public String getCustomer() {
        return "Customer Bob";
    }

    @RequestMapping("/new-span-for-subtask-in-same-service")
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
}
