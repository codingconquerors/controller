package com.liveitcourses.firstproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Any String";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        HelloWorldBean obj = new HelloWorldBean("Hello World", "Mehtab");
        return obj;
    }

    ///hello-world/path-variable/test
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(name, "Singh");
    }

    ///hello-world/request-param
    @GetMapping(path = "/hello-world/request-param")
    public HelloWorldBean helloWorldRequestParam(@RequestParam String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name), "Mehtab");
    }

}