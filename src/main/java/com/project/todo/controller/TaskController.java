package com.project.todo.controller;

import com.project.todo.dto.ResponseDTO;
import com.project.todo.dto.TaskDTO;
import com.project.todo.service.TaskService;
import com.project.todo.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/todo")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ResponseUtil responseUtil;

    @GetMapping(value = "/task")
    public ResponseEntity<List<TaskDTO>> getTaskList() {
        log.info("get api running");
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasks());
    }

    @PostMapping(value = "/task")
    public ResponseEntity<TaskDTO> saveTask(@RequestBody TaskDTO taskDto) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.saveTask(taskDto));
    }

    @GetMapping(value = "/task/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable(name = "id") String id) {
        TaskDTO taskDTO = taskService.getTask(id);
        return ResponseEntity.status(HttpStatus.OK).body(taskDTO);
    }

    @GetMapping(value = "/task1")
    public ResponseEntity<ResponseDTO> getTask2(@RequestParam String id) {
        log.info("id = {}", id);
        TaskDTO taskDTO = taskService.getTask(id);
        return responseUtil.sendResponse(true, HttpStatus.OK, "Data send", taskDTO, 1, 10);

//        return ResponseEntity.status(HttpStatus.OK).body(taskDTO);
    }

    @PutMapping(value = "/task/{id}")
    public ResponseEntity<ResponseDTO> updateTask(@RequestBody TaskDTO taskDto, @PathVariable(value = "id") String id) {
        TaskDTO taskDTOUpdate = taskService.updateTask(taskDto, id);
        return responseUtil
                .sendResponse(true, HttpStatus.OK, "Data fetch successfull",
                        taskDTOUpdate, 1, 1);
    }

}
