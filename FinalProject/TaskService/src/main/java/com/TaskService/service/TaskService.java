package com.TaskService.service;

import com.TaskService.dto.Project;
import com.TaskService.dto.TaskResponse;
import com.TaskService.entity.Task;
import com.TaskService.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?>  addTask(Task task, Long projectId) {
        String projectServiceUrl = "http://localhost:8080/project/find/" + projectId;
       ResponseEntity<Project> response = restTemplate.getForEntity(projectServiceUrl, Project.class);
       if (response.getStatusCode().is2xxSuccessful()) {
           task.setProjectId(projectId);
           Task savedTask = taskRepo.save(task);
           return ResponseEntity.ok(savedTask);
       } else {
           return ResponseEntity.status(response.getStatusCode()).body("Project Not found");
       }
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public ResponseEntity<?> getTaskById(Long id) {
        Optional<Task> task = taskRepo.findById(id);
        if (task.isPresent()) {
            Project project = restTemplate.getForObject("http://localhost:8080/project/find/" + task.get().getProjectId(), Project.class);
            TaskResponse taskResponse = new TaskResponse(
                    task.get().getId(),
                    task.get().getTitle(),
                    task.get().getDescription(),
                    task.get().getPriority(),
                    task.get().getStatus(),
                    project
            );
            return  new ResponseEntity<>(taskResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public void deleteTaskById(Long id) {
        taskRepo.deleteById(id);
    }

    public Task updateTask(Task task) {
        Task taskToUpdate = taskRepo.findById(task.getId()).get();
        task.setStatus(taskToUpdate.getStatus());
        return taskRepo.save(task);
    }
}
