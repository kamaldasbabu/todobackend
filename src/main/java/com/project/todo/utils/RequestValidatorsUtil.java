package com.project.todo.utils;

import com.project.todo.dto.TaskDTO;
import com.project.todo.exceptions.InvalidStatusException;
import com.project.todo.exceptions.RequestValidatorException;
import org.springframework.stereotype.Component;

@Component
public class RequestValidatorsUtil {
    public void taskRequestValidator(TaskDTO taskDTO) {
        if(taskDTO.getDescription().isEmpty()) {
            throw new RequestValidatorException(400, "Describe is missing");
        }

    }

}
