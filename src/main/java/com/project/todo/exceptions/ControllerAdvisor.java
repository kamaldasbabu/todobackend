package com.project.todo.exceptions;


import com.project.todo.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

@Slf4j
@RestControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ResponseDTO> runtimeExceptionHandler(RuntimeException runtimeException) {
        log.error(runtimeException.toString());
        ResponseDTO responseDTO = ResponseDTO.builder()
                .success(false)
                .message(runtimeException.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
    }

    @ExceptionHandler(value = RequestValidatorException.class)
    public ResponseEntity<ResponseDTO> requestValidatorsHandler(RequestValidatorException requestValidatorException) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .success(false)
                .message(requestValidatorException.getMessage())
                .statusCode(requestValidatorException.getCode())
                .build();
        return ResponseEntity.status(requestValidatorException.getCode()).body(responseDTO);
    }


}
