package com.alliance.travally.HelloWorld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloWorldControllerTest {

    @Test
    public void testHelloWorld() {
        HelloWorldControlller controlller = new HelloWorldControlller();
        String output = controlller.helloWorld();

        Assertions.assertEquals("Hello World!", output);
    }

}
