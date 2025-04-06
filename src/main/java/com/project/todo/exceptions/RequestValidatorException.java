package com.project.todo.exceptions;

public class RequestValidatorException extends RuntimeException{
    Integer code;

    public RequestValidatorException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public  Integer getCode() {
        return  this.code;
    }

}
