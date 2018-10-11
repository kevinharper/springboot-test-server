package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

@Component
public class HelloService {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Tracer tracer;

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

}
