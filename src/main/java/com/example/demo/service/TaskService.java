package com.example.demo.service;

import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.models.dto.request.TaskRequestDto;
import com.example.demo.models.dto.response.TaskResponseDto;
import com.example.demo.models.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.utils.SaveTask;
import com.example.demo.utils.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    private TaskMapper taskMapper;

    private SaveTask saveTask;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper , SaveTask saveTask) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.saveTask = saveTask;
    }

    public void addTaskService (TaskRequestDto taskRequestDto) {
        Task taskTobeAdded = taskMapper.toTask(taskRequestDto);
        saveTask.save(taskTobeAdded);
    }
    public  Task findTaskById(int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
    }

    public List<TaskResponseDto> getAllTasks(){
        List<Task>foundedTasks = taskRepository.findAll();

        return  foundedTasks.stream()
                .map(task -> new TaskResponseDto(
                        task.getId(),
                        task.getName(),
                        task.isFinished()
                ))
                .toList();
    }

    public TaskResponseDto editTaskStatus (int id , boolean newStatus) {
       Task userTask = findTaskById(id);
       userTask.setFinished(newStatus);
       taskRepository.save(userTask);
       return taskMapper.toDto(userTask);
    }

    public String deleteTaskById(int id) {
        Task userTask = findTaskById(id);
        taskRepository.deleteById(id);
        return "Task with id " + id + "deleted successfully";
    }

}
