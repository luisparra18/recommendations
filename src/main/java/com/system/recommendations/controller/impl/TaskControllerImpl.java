package com.system.recommendations.controller.impl;

import com.system.recommendations.controller.TaskController;
import com.system.recommendations.dto.MessageDTO;
import com.system.recommendations.dto.TaskDTO;
import com.system.recommendations.model.entity.Task;
import com.system.recommendations.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskControllerImpl  implements TaskController {

    private final TaskService taskService;

    @Override
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasks());
    }

    @Override
    public ResponseEntity<MessageDTO> saveTasks(TaskDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.saveTask(dto));
    }

    @Override
    public ResponseEntity<MessageDTO> updateTasks(TaskDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(dto));
    }

    @Override
    public ResponseEntity<MessageDTO> deleteTasks(Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.deleteTask(id));
    }

}
