package de.cat.rest.appcat.web;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloControllerUnitTest {

    @Test
    public void hello() {
        HelloController controller = new HelloController();
        assertThat(controller.hello(), is("Hello World"));
    }

    @Test
    public void helloName() {
        HelloController controller = new HelloController();
        String cat = "Cat";
        assertThat(controller.hello(cat), is("Hello " + cat));
    }
}