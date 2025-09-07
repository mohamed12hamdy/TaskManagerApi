package com.example.demo.utils;

import com.example.demo.models.dto.request.TaskRequestDto;
import com.example.demo.models.dto.response.TaskResponseDto;
import com.example.demo.models.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toTask (TaskRequestDto taskRequestDto) {
        Task newTask = new Task();
        newTask.setName(taskRequestDto.getName());
        newTask.setFinished(taskRequestDto.isFinished());
        return newTask;
    }

    public TaskResponseDto toDto(Task task) {
              TaskResponseDto dto = new TaskResponseDto();
              dto.setId(task.getId());
              dto.setName(task.getName());
              dto.setFinished(task.isFinished());
              return dto;
    }
}
