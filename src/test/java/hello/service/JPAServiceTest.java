package hello.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hello.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class HelloServiceTest {

    @Inject
    @Named("HelloService")
    private HelloService helloService;

    @Test
    public void testAddItem() {
        helloService.addItem("first");
        helloService.addItem("second");
        helloService.addItem("third");
        List<String> items = helloService.getItems();
        assertTrue(items.size() == 3);
        assertTrue(items.get(2).equals("third"));

    }

    @Test
    public void testDoSomeWorkNewSpan() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetCustomer() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetItems() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetCustomer() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetItems() {
        fail("Not yet implemented");
    }

}
