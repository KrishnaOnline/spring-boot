package com.krish.springbootjpa.practice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    @GetMapping
    public String sayHello() {
        return "Hello from FirstController";
    }

    @GetMapping("/hello2")
    @ResponseStatus(HttpStatus.CREATED)
    public String sayHello2() {
        return "Hello 2 from FirstController";
    }

    @PostMapping("/post-msg")
    public String postMsg(@RequestBody String message) {
        return "Request Accepted and Posted Message is: "+message;
    }

    @PostMapping("/post-order")
    public String postOrder(@RequestBody Order order) {
        return "Request Accepted and Order is: "+order.toString();
    }

    @PostMapping("/post-order-record")
    public String postOrderRecord(@RequestBody OrderRecord order) {
        return "Request Accepted and Order is: "+order.toString();
    }

    // localhost:8080/hello/charan
    @GetMapping("/hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String userName) {
        return "The value is: "+userName;
    }

    // localhost:8080/hello?name=charan&age=35
    @GetMapping("/hello")
    public String paramVar(@RequestParam("name") String name, @RequestParam("age") int age) {
        return "The values are: "+name+" and "+age;
    }
}
