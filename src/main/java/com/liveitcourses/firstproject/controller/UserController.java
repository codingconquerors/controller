package com.liveitcourses.firstproject.controller;

import java.util.List;
import java.util.Locale;

import com.liveitcourses.firstproject.dto.User;
import com.liveitcourses.firstproject.exception.UserNotFoundException;
import com.liveitcourses.firstproject.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }

    @GetMapping("/user/{id}")
    public EntityModel<User> retrieveUserWithHateOS(@PathVariable int id) {

        User user =  service.findOne(id);

        EntityModel<User> model = EntityModel.of(user);

        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        model.add(linkToUsers.withRel("all-users"));

        return model;
    }

    //   input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/users")
    public void createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);

        if(user==null)
            throw new UserNotFoundException("id-"+ id);
    }

    @GetMapping(path = "/i18l")
    public String internationalization() {
        return messageSource.getMessage("good.morning.message", null,"default messages",
                LocaleContextHolder.getLocale());
    }

}