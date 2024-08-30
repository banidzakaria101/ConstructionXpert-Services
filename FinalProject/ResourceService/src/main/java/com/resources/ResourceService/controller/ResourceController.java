package com.resources.ResourceService.controller;

import com.resources.ResourceService.entity.Resource;
import com.resources.ResourceService.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/add/{taskId}")
    public ResponseEntity<?> addResource(@PathVariable  Long taskId, @RequestBody Resource resource) {
        return resourceService.addResource(resource, taskId);
    }

    @GetMapping("/find/{taskId}")
    public ResponseEntity<?> findResourceByTaskId(@PathVariable Long taskId) {
        return resourceService.getResourceByTaskId(taskId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteResource(@PathVariable Long id) {
        resourceService.deleteResourceById(id);
    }

    @PostMapping("/update/{resourceId}")
    public Resource updateResource(@RequestBody Resource resource, @PathVariable Long resourceId) {
        return resourceService.updateResource(resource, resourceId);
    }

    @GetMapping("/list")
    public List<Resource> listResource() {
        return resourceService.getAllResources();
    }

}
