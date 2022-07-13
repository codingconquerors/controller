package com.liveitcourses.firstproject.dto;

import org.springframework.context.annotation.Bean;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;

public class User {

    @Positive
    private Integer id;

    @Size(min = 3, max = 20, message = "Name field in User object must be between 3 and 20 chars long")
    private String name;

    @Past
    private Date birthDate;

    public User(Integer id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
    }

}