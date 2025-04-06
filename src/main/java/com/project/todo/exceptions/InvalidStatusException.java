package com.project.todo.exceptions;


import lombok.Getter;

@Getter
public class InvalidStatusException extends RuntimeException {

    Integer code;

    public InvalidStatusException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
