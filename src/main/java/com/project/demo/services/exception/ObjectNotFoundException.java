package com.project.demo.services.exception;

public class ObjectNotFoundException extends RuntimeException {


    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
