package com.example.demo.controller;

import com.example.demo.models.dto.request.TaskRequestDto;
import com.example.demo.models.dto.response.TaskResponseDto;
import com.example.demo.models.entity.Task;
import com.example.demo.service.TaskService;
import com.example.demo.utils.TaskMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskMapper taskMapper;

    private final TaskService taskService;

    public TaskController(TaskService taskService , TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTask ( @Valid @RequestBody TaskRequestDto taskRequestDto) {
        taskService.addTaskService(taskRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Task created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> findTaskById(@PathVariable int id) {
        Task foundedTask = taskService.findTaskById(id);
        return ResponseEntity.ok(taskMapper.toDto(foundedTask));

    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        List<TaskResponseDto> dtos = taskService.getAllTasks();
        return ResponseEntity.ok(dtos);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<TaskResponseDto> editTaskStatus (@PathVariable int id , @RequestParam boolean newStatus) {
         return ResponseEntity.ok(taskService.editTaskStatus(id, newStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteTaskById (@PathVariable int id) {
         return ResponseEntity.ok(taskService.deleteTaskById(id));
    }

}
