package com.project.todo.service;

import com.project.todo.dto.PayloadDTO;
import org.springframework.stereotype.Service;

@Service
public class Calculation {
    public Integer add(PayloadDTO payloadDTO) {
        return payloadDTO.getValue1() + payloadDTO.getValue2();
    }
}
