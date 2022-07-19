package com.liveitcourses.firstproject.service;

import com.liveitcourses.firstproject.dto.User;
import com.liveitcourses.firstproject.exception.UserNotFoundException;
import com.liveitcourses.firstproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserJPAService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findOne(int id) {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new UserNotFoundException("id-"+ id);
        }
        return user.get();
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }


}