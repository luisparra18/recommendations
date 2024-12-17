package com.system.recommendations.controller;

import com.system.recommendations.constants.ApiEndpoints;
import com.system.recommendations.dto.MessageDTO;
import com.system.recommendations.dto.TaskDTO;
import com.system.recommendations.model.entity.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TaskController {

    @GetMapping(ApiEndpoints.TASK)
    @ResponseStatus
    ResponseEntity<List<Task>> getTasks();
    @PostMapping(ApiEndpoints.TASK)
    @ResponseStatus
    ResponseEntity<MessageDTO> saveTasks(@RequestBody TaskDTO dto);
    @PutMapping(ApiEndpoints.TASK)
    @ResponseStatus
    ResponseEntity<MessageDTO> updateTasks(@RequestBody TaskDTO dto);
    @DeleteMapping(ApiEndpoints.TASK)
    @ResponseStatus
    ResponseEntity<MessageDTO> deleteTasks(@RequestParam Integer id);
}
