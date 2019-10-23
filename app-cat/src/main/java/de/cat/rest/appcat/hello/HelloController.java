package de.cat.rest.appcat.hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping()
    public String hello() {
        return "Hello World";
    }


    @RequestMapping("/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }

}
