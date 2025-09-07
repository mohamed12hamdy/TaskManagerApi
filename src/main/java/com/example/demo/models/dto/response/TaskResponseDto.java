package com.example.demo.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TaskResponseDto {

    private int id;

    private String name;

    private boolean isFinished;

}
