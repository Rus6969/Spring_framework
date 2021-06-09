package com.cybertek.exception;

public class ServiceException extends Exception {
// custom exception class now we can use exception in User Service
    public ServiceException(String message){
        super(message);
    }
}