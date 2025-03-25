package com.project.todo.controller;
import com.project.todo.dto.TaskDTO;
import com.project.todo.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/todo/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTaskList() {
        log.info("get api running");
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasks());
    }

    @PostMapping
    public ResponseEntity<TaskDTO> saveTask(@RequestBody TaskDTO taskDto) {
        return  ResponseEntity.status(HttpStatus.OK).body(taskService.saveTask(taskDto));
    }
    @GetMapping
    public ResponseEntity<TaskDTO> getTask(@RequestParam String id) {
        TaskDTO taskDTO = taskService.getTask(id);
        return ResponseEntity.status(HttpStatus.OK).body(taskDTO);
    }

    @PutMapping
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDto, @RequestParam String id) {
        return  ResponseEntity.status(HttpStatus.OK).body(taskService.saveTask(taskDto));
    }
}
