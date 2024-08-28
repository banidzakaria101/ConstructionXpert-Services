package com.ProjectService.Controller;

import com.ProjectService.Services.ProjectService;
import com.ProjectService.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/project")
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectsService;

    @PostMapping("/new")
    public Project newProject(@RequestBody Project project) {
        return projectsService.createProject(project);
    }

    @GetMapping("/all")
    public List<Project> getAllProject() {
        return projectsService.getAllProjects();
    }

    @GetMapping("/find/{id}")
    public Project findProject(@PathVariable Long id) {
        return projectsService.getProject(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectsService.deleteProject(id);
    }
}
