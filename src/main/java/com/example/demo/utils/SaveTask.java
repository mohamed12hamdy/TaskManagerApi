package com.example.demo.utils;

import com.example.demo.models.dto.request.TaskRequestDto;
import com.example.demo.models.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Component;

@Component
public class SaveTask {

    private TaskRepository taskRepository;

    public SaveTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(Task task) {
        taskRepository.save(task);
    }
}
