package com.liveitcourses.firstproject.controller;

// model classes
// pojo plain old java objects
// DTO data transfer objects
// domain object
// Entities
// DAO
public class HelloWorldBean {

    private String message;

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HelloWorldBean(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message=%s]", message);
    }

}
