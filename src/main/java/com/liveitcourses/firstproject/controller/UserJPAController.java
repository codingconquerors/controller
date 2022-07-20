package com.liveitcourses.firstproject.controller;

import com.liveitcourses.firstproject.dto.Post;
import com.liveitcourses.firstproject.dto.User;
import com.liveitcourses.firstproject.exception.UserNotFoundException;
import com.liveitcourses.firstproject.repository.PostRepository;
import com.liveitcourses.firstproject.service.UserJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserJPAService service;

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }

    @GetMapping("/jpa/user/{id}")
    public EntityModel<User> retrieveUserWithHateOS(@PathVariable int id) {

        User user = service.findOne(id);

        EntityModel<User> model = EntityModel.of(user);

        WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).retrieveAllUsers());

        model.add(linkToUsers.withRel("all-users"));

        return model;
    }

    //   input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllUsers(@PathVariable int id) {
        User user = service.findOne(id);


        return user.getPosts();
    }


    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {

        User user = service.findOne(id);


        post.setUser(user);

        postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    // create delete resource

    // update an existing post :PUT method
}