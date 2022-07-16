package com.liveitcourses.firstproject.controller;


import com.liveitcourses.firstproject.dto.Name;
import com.liveitcourses.firstproject.dto.PersonV1;
import com.liveitcourses.firstproject.dto.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    // 1st way is through url
    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie V1");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // 2nd way is through query param : can pollute our urls

    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }


    // 3rd way  is through the header
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // 4th type mime type versioning or producer versioning
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

}