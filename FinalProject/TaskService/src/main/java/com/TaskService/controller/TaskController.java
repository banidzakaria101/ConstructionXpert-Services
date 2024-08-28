package com.TaskService.controller;

import com.TaskService.entity.Task;
import com.TaskService.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("/add/{projectId}")
    public ResponseEntity<?> addTask(@RequestBody Task task, @PathVariable Long projectId) {
        return taskService.addTask(task, projectId);
    }

    @GetMapping("/list")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }


}
