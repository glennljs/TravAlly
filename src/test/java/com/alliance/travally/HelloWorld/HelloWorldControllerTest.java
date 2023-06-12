package com.alliance.travally.HelloWorld;

import com.alliance.travally.HelloWorldControlller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloWorldControllerTest {

    @Test
    public void testHelloWorld() {
        HelloWorldControlller controlller = new HelloWorldControlller();
        String output = controlller.helloWorld();

        Assertions.assertEquals("Hello World!", output);
    }

}
