package com.project.todo.controller;


import com.project.todo.dto.TaskUserDTO;
import com.project.todo.dto.TaskUserViewDTO;
import com.project.todo.service.TaskUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/todo")
public class TaskUserController {

    @Autowired
    private TaskUserService taskUserService;
    @GetMapping(value = "/task-user/{userId}")
    public TaskUserViewDTO getTaskUser(@PathVariable(value = "userId") String userId) {
        log.info("userId {}", userId);
        return taskUserService.getTaskByUser(userId);
    }

    @PostMapping(value = "/task-user/assign")

    public ResponseEntity<TaskUserDTO> assignTaskToUser(@RequestBody TaskUserDTO taskUserDTO) {
        TaskUserDTO td = taskUserService.assignTaskToUser(taskUserDTO);
        return ResponseEntity.status(HttpStatus.OK).body(td);
    }

}
