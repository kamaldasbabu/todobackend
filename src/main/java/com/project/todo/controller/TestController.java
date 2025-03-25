package com.project.todo.controller;

import com.project.todo.dto.PayloadDTO;
import com.project.todo.service.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private Calculation calculation;
    @GetMapping(value="/ping")
    public ResponseEntity<String> getPing() {
        return ResponseEntity.status(HttpStatus.OK).body("Ping Pong - Server is Running");
    }

    @PostMapping(value="/add")
    public ResponseEntity<Integer> addValue(@RequestBody PayloadDTO payloadDTO)  {
        System.out.println(payloadDTO);

        return ResponseEntity.status(HttpStatus.OK).body(calculation.add(payloadDTO));
    }
}
