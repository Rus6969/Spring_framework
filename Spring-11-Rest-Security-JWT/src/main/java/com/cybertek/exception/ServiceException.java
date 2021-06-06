package com.cybertek.exception;

public class ServiceException extends Exception {
// custo exception class now we can use exception in User Service
    public ServiceException(String message){
        super(message);
    }
}