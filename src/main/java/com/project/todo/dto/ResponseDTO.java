package com.project.todo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class ResponseDTO {
    Boolean success;
    Integer statusCode;
    String message;
    Object data;
    Integer pageNo;
    Integer count;
}
