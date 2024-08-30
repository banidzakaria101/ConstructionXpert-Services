package com.resources.ResourceService.service;

import com.resources.ResourceService.dto.Task;
import com.resources.ResourceService.entity.Resource;
import com.resources.ResourceService.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepo;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> addResource(Resource resource, Long taskId) {
        String taskServiceUrl = "http://localhost:8081/task/find/" + taskId;
        ResponseEntity<Task> taskResponseEntity = restTemplate.getForEntity(taskServiceUrl, Task.class);
        if (taskResponseEntity.getStatusCode().is2xxSuccessful()) {
            resource.setTaskId(taskId);
            Resource savedResource  = resourceRepo.save(resource);
            return ResponseEntity.ok(savedResource);
        }else {
            return ResponseEntity.status(taskResponseEntity.getStatusCode()).body("Task Not Found");
        }
    }

    public ResponseEntity<?> getResourceByTaskId(Long taskId) {
        String taskServiceUrl = "http://localhost:8081/task/find/" + taskId;
        ResponseEntity<Task> taskResponseEntity = restTemplate.getForEntity(taskServiceUrl, Task.class);
        if (taskResponseEntity.getStatusCode().is2xxSuccessful()) {
            Task task = taskResponseEntity.getBody();

            return ResponseEntity.ok(task);
        }else{
            return ResponseEntity.status(taskResponseEntity.getStatusCode()).body("Task Not Found");
        }



    }

    public List<Resource> getAllResources() {
        return resourceRepo.findAll();
    }

    public void deleteResourceById(Long id) {
        resourceRepo.deleteById(id);
    }

    public Resource updateResource(Resource resource, Long resourceId) {
        Resource resource1 = resourceRepo.findById(resourceId).get();
        resource1.setResourceName(resource.getResourceName());
        return  resourceRepo.save(resource);
    }
}
