package com.example.demo.models.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequestDto {

    @NotBlank(message = "Task name can not be null")
    private String name;

    private boolean isFinished;

}
