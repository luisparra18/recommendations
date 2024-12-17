package com.system.recommendations.service;

import com.system.recommendations.dto.MessageDTO;
import com.system.recommendations.dto.TaskDTO;
import com.system.recommendations.model.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();
    MessageDTO saveTask(TaskDTO dto);
    MessageDTO updateTask(TaskDTO dto);
    MessageDTO deleteTask(Integer id);

}
