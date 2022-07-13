package com.liveitcourses.firstproject.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp; // current time when exception is raised
    private String message; // passing inside exception
    private String details; // other details

    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ExceptionResponse(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}