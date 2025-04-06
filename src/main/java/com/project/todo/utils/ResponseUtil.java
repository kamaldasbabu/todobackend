package com.project.todo.utils;

import com.project.todo.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {
    public ResponseEntity<ResponseDTO> sendResponse(
            Boolean success,
            HttpStatus statusCode,
            String message,
            Object data,
            Integer pageNo,
            Integer count )  {

        ResponseDTO responseDTO = ResponseDTO.builder()
                .success(success)
                .statusCode(statusCode.value())
                .message(message)
                .data(data)
                .pageNo(pageNo)
                .count(count)
                .build();

    return ResponseEntity.status(statusCode).body(responseDTO);
    }
}
