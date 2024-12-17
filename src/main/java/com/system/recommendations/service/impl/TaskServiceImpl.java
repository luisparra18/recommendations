package com.system.recommendations.service.impl;

import com.system.recommendations.dto.MessageDTO;
import com.system.recommendations.dto.TaskDTO;
import com.system.recommendations.exceptions.TaskException;
import com.system.recommendations.model.entity.Task;
import com.system.recommendations.repository.TaskRepository;
import com.system.recommendations.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import io.vavr.control.Try;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    @Override
    public List<Task> getTasks() {
        return Try.of(taskRepository::findAll).getOrElseThrow(e -> new TaskException("Error in service getTasks.", e));
    }

    @Override
    public MessageDTO saveTask(TaskDTO dto) {
        return Try.of(() -> {
                    Task task = Task.builder().title(dto.getTitle()).description(dto.getDescription()).expiryDate(LocalDateTime.now()).build();
                    return taskRepository.save(task);
                })
                .map(savedTask -> MessageDTO.builder().idTask(savedTask.getId()).message("Task saved successfully.").build())
                .getOrElseThrow(e -> new TaskException("Error saving task.", e));
    }


    @Override
    public MessageDTO updateTask(TaskDTO dto) {
        return Try.of(() -> {
                    if (dto.getId() <= 0) throw new TaskException("Invalid Task id");
                   return  taskRepository.findById(dto.getId()).map(task -> {
                       task.setTitle(dto.getTitle());
                       task.setDescription(dto.getDescription());
                       Task updateTask = taskRepository.save(task);
                       return MessageDTO.builder().idTask(updateTask.getId()).message("Task updated successfully").build();
                   }).orElseThrow(() -> new TaskException("Task not found with Id: " + dto.getId()));
                }).getOrElseThrow(ex -> {throw new TaskException("Error updating task: " + ex.getMessage(), ex);
        });
    }

    @Override
    public MessageDTO deleteTask(Integer id) {
        return Try.of(() -> {
                    taskRepository.deleteById(id);
                    return id;
                })
                .map(deletedId -> MessageDTO.builder().idTask(deletedId).message("Task with Id: " + deletedId + " has been successfully deleted.").build())
                .getOrElseThrow(ex -> new TaskException("Error occurred while deleting the task with Id: " + id, ex));
    }



}
